package com.orderinventory.dto;

import com.orderinventory.entities.Inventory;
import com.orderinventory.entities.Shipment;

public class InventoryShipment {
	private Shipment shipment;
	private Inventory inventory;
	/**
	 * @param shipment
	 * @param inventory
	 */
	public InventoryShipment(Shipment shipment, Inventory inventory) {
		super();
		this.shipment = shipment;
		this.inventory = inventory;
	}
	/**
	 * 
	 */
	public InventoryShipment() {
		super();
	}
	/**
	 * @return the shipment
	 */
	public Shipment getShipment() {
		return shipment;
	}
	/**
	 * @param shipment the shipment to set
	 */
	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}
	/**
	 * @return the inventory
	 */
	public Inventory getInventory() {
		return inventory;
	}
	/**
	 * @param inventory the inventory to set
	 */
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
}
