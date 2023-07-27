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

import com.orderinventory.dto.OrderInsight;
import com.orderinventory.dto.OrderStatusCount;
import com.orderinventory.dto.OrderStoreList;
import com.orderinventory.dto.ProdBrandCount;
import com.orderinventory.entities.Order;
import com.orderinventory.exceptions.InvaliddataException;
import com.orderinventory.exceptions.NotFoundException;
import com.orderinventory.services.OrderServices;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/orders")
public class OrderController {

	@Autowired
	private OrderServices orderServices;

	@GetMapping
	public ResponseEntity<List<Order>> getAllOrders() {
		List<Order> orders = orderServices.getAllOrders();

		if (orders.isEmpty()) {
			throw new NotFoundException("No orders found");
		}

		return ResponseEntity.ok(orders);
	}

	@PostMapping
	public ResponseEntity<String> addOrder(@RequestBody Order order) {
		Order addedOrder = orderServices.addOrder(order);

		if (addedOrder != null) {
			return ResponseEntity.ok("Record created Successfully");
		}
		throw new InvaliddataException("Record creation has failed!");
	}

	@PutMapping
	public ResponseEntity<String> updateOrder(@RequestBody Order order) {
		Order updatedOrder = orderServices.updateOrder(order);

		if (updatedOrder != null) {
			return ResponseEntity.ok("Record Updated Successfully");
		} else {
			throw new NotFoundException("No order found for the provided ID: " + order.getOrderId());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteOrder(@PathVariable("id") int id) {
		String result = orderServices.deleteOrderById(id);

		if (result.equals("failed")) {
			throw new NotFoundException("No order found for the provided ID: " + id);
		}

		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

	@GetMapping("/status")
	public ResponseEntity<List<OrderStatusCount>> getOrderCountByStatus(
			@RequestParam("orderstatus") String orderStatus) {
		List<OrderStatusCount> orderCountList = orderServices.getOrderCountByStatus(orderStatus);

		if (orderCountList.isEmpty()) {
			throw new InvaliddataException("No orders found for the provided order status: " + orderStatus);
		}

		return ResponseEntity.ok(orderCountList);
	}

	@GetMapping("/store")
	public ResponseEntity<List<OrderStoreList>> getOrderListByStoreId(@RequestParam("storeid") int storeId) {
		List<OrderStoreList> orderList = orderServices.getOrdersByStoreId(storeId);

		if (orderList.isEmpty()) {
			throw new NotFoundException("No orders found for the provided store ID: " + storeId);
		}

		return ResponseEntity.ok(orderList);
	}

	@GetMapping("/insight")
	public List<OrderInsight> getAllOrderInsightByYearorMonth(@RequestParam(name = "year") Integer year,
			@RequestParam(name = "month", required = false) Integer month) {

		if (month == null) {
			return orderServices.getAllOrderInsightByYear(year);
		}
		return orderServices.getAllOrderInsightByYearMonth(year, month);
	}

	@GetMapping("/productcount")
	public List<ProdBrandCount> getProductBrandCountByYandM(@RequestParam(name = "year") Integer year,
			@RequestParam(name = "month", required = false) Integer month) {
		if (month == null) {
			return orderServices.getProductBrandCount(year);
		}
		return orderServices.getProductBrandCountByYandM(year, month);
	}
}
