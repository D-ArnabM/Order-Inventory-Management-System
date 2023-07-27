package com.orderinventory.dto;

public class OrderStatusCount {
	
	private String orderStatus;
	private Long count;
	
	/**
	 * 
	 */
	public OrderStatusCount() {
		super();
	}

	/**
	 * @param orderStatus
	 * @param count
	 */
	public OrderStatusCount(String orderStatus, Long count) {
		super();
		this.orderStatus = orderStatus;
		this.count = count;
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
