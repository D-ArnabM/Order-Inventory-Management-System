package com.orderinventory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orderinventory.dto.CustomerOrders;
import com.orderinventory.dto.CustomerShipment;
import com.orderinventory.dto.ShipmentStatusCountCustomer;
import com.orderinventory.entities.Customer;
import com.orderinventory.exceptions.InvaliddataException;
import com.orderinventory.exceptions.NotFoundException;
import com.orderinventory.services.CustomerServices;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/customers")
public class CustomerController {

	@Autowired
	private CustomerServices cust;

	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomers(
			@RequestParam(name = "name", required = false) String fullName) {
		if (fullName != null) {
			List<Customer> customersByFullName = cust.getCustomersByFullName(fullName);
			if (customersByFullName.isEmpty()) {
				throw new NotFoundException("Name is not found");
			}
			return ResponseEntity.ok(customersByFullName);
		} else {
			List<Customer> allCustomers = cust.getAllCustomers();
			if (allCustomers.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(allCustomers);
			}
			return ResponseEntity.ok(allCustomers);
		}
	}

	@PostMapping
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
		Customer c1 = cust.addCustomer(customer);

		if (c1 == null) {
			throw new InvaliddataException("Record Created failed");
		}
		return new ResponseEntity<String>("Record Creation successfully", HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<String> updateCustomer(@RequestBody Customer customer) {
		Customer updatedCustomer = cust.updateCustomer(customer);
		if (updatedCustomer == null) {
			throw new InvaliddataException("Record Updated Successfully");
		}

		return new ResponseEntity<String>("Record Updation failed", HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") int id) {
		String result = cust.deleteCustomer(id);

		if (result.equals("Record not found")) {
			throw new NotFoundException("No customer found for the provided ID: " + id);
		}

		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

	@GetMapping("/{email}")
	public ResponseEntity<List<Customer>> getCustomersByEmailAddress(@PathVariable("email") String emailAddress) {
		List<Customer> customers = cust.getCustomerByEmailAddress(emailAddress);

		if (customers.isEmpty()) {
			throw new NotFoundException("No customers found with the provided email address");
		}

		return ResponseEntity.ok(customers);
	}

	@GetMapping("/shipment/status")
	public ResponseEntity<List<ShipmentStatusCountCustomer>> getOrderCountByStatus() {
		List<ShipmentStatusCountCustomer> shipmentStatusCount = cust.getOrderCountByStatus();

		if (shipmentStatusCount.isEmpty()) {
			throw new InvaliddataException("No shipment status count found");
		}

		return new ResponseEntity<List<ShipmentStatusCountCustomer>>(shipmentStatusCount, HttpStatus.OK);
	}

	@GetMapping("/{custid}/order")
	public ResponseEntity<CustomerOrders> getCustomerOrders(@PathVariable("custid") int customerId) {
		CustomerOrders customerOrders = cust.getCustomerOrders(customerId);

		if (customerOrders.getCustomer() == null && customerOrders.getOrder().isEmpty()) {
			throw new NotFoundException("No customer orders found for the provided customer ID: " + customerId);
		}

		return ResponseEntity.ok(customerOrders);
	}

	@GetMapping("/{custid}/shipment")
	public ResponseEntity<CustomerShipment> getCustomerShipment(@PathVariable("custid") int customerId) {
		CustomerShipment customerShipment = cust.getCustomerShipment(customerId);

		if (customerShipment.getCustomer() == null && customerShipment.getShipment().isEmpty()) {
			throw new NotFoundException("No customer shipment found for the provided customer ID: " + customerId);
		}

		return ResponseEntity.ok(customerShipment);
	}

}
