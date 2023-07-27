package com.orderinventory.dto;

public class ShipmentStatusSoldProducts {
	private String shipmentStatus;
	private Long soldProducts;
	/**
	 * @param shipmentStatus
	 * @param soldProducts
	 */
	public ShipmentStatusSoldProducts(String shipmentStatus, Long soldProducts) {
		super();
		this.shipmentStatus = shipmentStatus;
		this.soldProducts = soldProducts;
	}
	/**
	 * 
	 */
	public ShipmentStatusSoldProducts() {
		super();
	}
	/**
	 * @return the shipmentStatus
	 */
	public String getShipmentStatus() {
		return shipmentStatus;
	}
	/**
	 * @param shipmentStatus the shipmentStatus to set
	 */
	public void setShipmentStatus(String shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}
	/**
	 * @return the soldProducts
	 */
	public Long getSoldProducts() {
		return soldProducts;
	}
	/**
	 * @param soldProducts the soldProducts to set
	 */
	public void setSoldProducts(Long soldProducts) {
		this.soldProducts = soldProducts;
	}
	
}
