package com.orderinventory.controllers;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.orderinventory.dto.InventoryProductCustomerStore;
import com.orderinventory.dto.InventoryProductOrderStatus;
import com.orderinventory.dto.InventoryProductStoreShipmentStatusSum;
import com.orderinventory.dto.InventoryShipment;
import com.orderinventory.dto.ShipmentStatusSoldProducts;
import com.orderinventory.entities.Inventory;
import com.orderinventory.exceptions.InvaliddataException;
import com.orderinventory.exceptions.NotFoundException;
import com.orderinventory.services.InventoryServices;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/inventory")
public class InventoryController {

	@Autowired
	private InventoryServices inventoryServices;

	@GetMapping
	public ResponseEntity<List<Inventory>> getAllInventory() {
		List<Inventory> inventoryList = inventoryServices.getAllInventory();

		if (inventoryList.isEmpty()) {
			throw new NotFoundException("No inventory items found");
		}

		return ResponseEntity.ok(inventoryList);
	}

	@GetMapping("/orderid/{id}")
	public ResponseEntity<InventoryProductCustomerStore> getProductCustomerStoreByOrderId(
			@PathVariable("id") int orderId) {
		InventoryProductCustomerStore result = inventoryServices.getProductCustomerStoreByOrderId(orderId);

		if (result == null) {
			throw new InvaliddataException(
					"No inventory product customer store found for the provided order ID: " + orderId);
		}

		return ResponseEntity.ok(result);
	}

	@GetMapping("/{orderid}/details")
	public ResponseEntity<List<InventoryProductStoreShipmentStatusSum>> getInventoryDetailsByOrderId(
			@PathVariable("orderid") int orderId) {
		List<InventoryProductStoreShipmentStatusSum> result = inventoryServices.getInventoryDetailsByOrderId(orderId);

		if (result.isEmpty()) {
			throw new NotFoundException("No inventory details found for the provided order ID: " + orderId);
		}

		return ResponseEntity.ok(result);
	}

	@GetMapping("/store")
	public ResponseEntity<List<InventoryProductOrderStatus>> getProductOrderStatusByStoreId(@RequestParam("storeid") int storeId) {
		List<InventoryProductOrderStatus> result = inventoryServices.getProductOrderStatusByStoreId(storeId);

		if (result == null) {
			throw new NotFoundException(
					"No product, order, or status details found for the provided store ID: " + storeId);
		}

		return new ResponseEntity<List<InventoryProductOrderStatus>>( result,HttpStatus.OK);
	}

	@GetMapping("/shipmentid")
	public ResponseEntity<List<InventoryShipment>> getInventoryShipmentById() {
		List<InventoryShipment> inventoryShipments = inventoryServices.getInventoryShipmentById();

		if (inventoryShipments.isEmpty()) {
			throw new NotFoundException("No inventory shipment details found");
		}

		return new ResponseEntity<List<InventoryShipment>>(inventoryShipments,HttpStatus.OK);
	}

	@GetMapping("/shipment/soldproducts")
	public ShipmentStatusSoldProducts getCountOfSoldProductsByShipmentStatus() {
		return inventoryServices.getCountOfSoldProductsByShipmentStatus();
	}
}