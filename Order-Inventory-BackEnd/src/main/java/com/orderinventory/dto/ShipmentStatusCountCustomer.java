package com.orderinventory.dto;

public class ShipmentStatusCountCustomer {
	private String shipmentStatus;
	private Long count;
	/**
	 * @param shipmentStatus
	 * @param count
	 */
	public ShipmentStatusCountCustomer(String shipmentStatus, Long count) {
		super();
		this.shipmentStatus = shipmentStatus;
		this.count = count;
	}
	/**
	 * 
	 */
	public ShipmentStatusCountCustomer() {
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
	 * @return the count
	 */
	public Long getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(Long count) {
		this.count = count;
	}
}
