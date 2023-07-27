package com.orderinventory.dto;

public class OrderStoreList {
	private int orderId;
	private String orderStatus;
	private String storeName;
	private String webAddress;
	
	/**
	 * 
	 */
	public OrderStoreList() {
		super();
	}
	/**
	 * @param orderId
	 * @param orderStatus
	 * @param storeName
	 * @param webAddress
	 */
	public OrderStoreList(int orderId, String orderStatus, String storeName, String webAddress) {
		super();
		this.orderId = orderId;
		this.orderStatus = orderStatus;
		this.storeName = storeName;
		this.webAddress = webAddress;
	}
	/**
	 * @return the orderId
	 */
	public int getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return the orderStatus
	 */
	public String getOrderStatus() {
		return orderStatus;
	}
	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	/**
	 * @return the storeName
	 */
	public String getStoreName() {
		return storeName;
	}
	/**
	 * @param storeName the storeName to set
	 */
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	/**
	 * @return the webAddress
	 */
	public String getWebAddress() {
		return webAddress;
	}
	/**
	 * @param webAddress the webAddress to set
	 */
	public void setWebAddress(String webAddress) {
		this.webAddress = webAddress;
	}
	
}
