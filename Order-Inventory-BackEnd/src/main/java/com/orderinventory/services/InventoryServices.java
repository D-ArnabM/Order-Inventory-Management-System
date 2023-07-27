package com.orderinventory.services;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import com.orderinventory.dto.InventoryProductCustomerStore;
import com.orderinventory.dto.InventoryProductOrderStatus;
import com.orderinventory.dto.InventoryProductStoreShipmentStatusSum;
import com.orderinventory.dto.InventoryShipment;
import com.orderinventory.dto.ShipmentStatusSoldProducts;
import com.orderinventory.entities.Inventory;
import com.orderinventory.entities.Store;
import com.orderinventory.repo.InventoryRepository;
import com.orderinventory.repo.ShipmentRepository;
import com.orderinventory.repo.StoreRepository;

@Service
public class InventoryServices implements InventoryServiceInterface {

	@Autowired
	private InventoryRepository inventoryRepository;
	
	@Autowired
	private StoreRepository storeRepository;

	@Autowired
	private ShipmentRepository shipmentRepository;

	public List<Inventory> getAllInventory() {
		return inventoryRepository.findAll();
	}

	public InventoryProductCustomerStore getProductCustomerStoreByOrderId(int orderId) {
		return inventoryRepository.findProductCustomerStoreByOrderId(orderId);
	}

	public List<InventoryProductStoreShipmentStatusSum> getInventoryDetailsByOrderId(@Param("orderId") int orderId) {
		return inventoryRepository.findInventoryDetailsByOrderId(orderId);
	}

	public List<InventoryProductOrderStatus> getProductOrderStatusByStoreId(int storeId) {

		Store store = storeRepository.findById(storeId).orElse(null);
		if (store != null) {
			return inventoryRepository.findProductOrderStatusByStoreId(storeId);
		}
		return null;
	}

	public List<InventoryShipment> getInventoryShipmentById() {
		List<Integer> allId = shipmentRepository.findAllShipmentId();
		List<InventoryShipment> inventoryShipment = new ArrayList<>();
		for (int id : allId) {
			inventoryShipment.add(inventoryRepository.findInventoryShipmentById(id));
		}
		return inventoryShipment;
	}

	public ShipmentStatusSoldProducts getCountOfSoldProductsByShipmentStatus() {
		return inventoryRepository.findSoldProductsByShipmentStatus();
	}
}
