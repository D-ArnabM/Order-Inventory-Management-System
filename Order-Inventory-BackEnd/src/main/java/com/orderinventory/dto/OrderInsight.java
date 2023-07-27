package com.orderinventory.dto;

import java.math.BigDecimal;

public class OrderInsight {
	private Long noOfOrders;
	private Long quantity;
	private Integer month;
	private BigDecimal totalSales;
	/**
	 * @param noOfOrders
	 * @param quantity
	 * @param month
	 * @param totalSales
	 */
	public OrderInsight(Long noOfOrders, Long quantity, Integer month, BigDecimal totalSales) {
		super();
		this.noOfOrders = noOfOrders;
		this.quantity = quantity;
		this.month = month;
		this.totalSales = totalSales;
	}
	/**
	 * 
	 */
	public OrderInsight() {
		super();
	}
	/**
	 * @return the noOfOrders
	 */
	public Long getNoOfOrders() {
		return noOfOrders;
	}
	/**
	 * @param noOfOrders the noOfOrders to set
	 */
	public void setNoOfOrders(Long noOfOrders) {
		this.noOfOrders = noOfOrders;
	}
	/**
	 * @return the quantity
	 */
	public Long getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the month
	 */
	public Integer getMonth() {
		return month;
	}
	/**
	 * @param month the month to set
	 */
	public void setMonth(Integer month) {
		this.month = month;
	}
	/**
	 * @return the totalSales
	 */
	public BigDecimal getTotalSales() {
		return totalSales;
	}
	/**
	 * @param totalSales the totalSales to set
	 */
	public void setTotalSales(BigDecimal totalSales) {
		this.totalSales = totalSales;
	}
}
