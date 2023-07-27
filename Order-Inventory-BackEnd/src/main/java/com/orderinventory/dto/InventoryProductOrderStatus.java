package com.orderinventory.dto;

import com.orderinventory.entities.Product;

public class InventoryProductOrderStatus {
	private Product product;
	private String orderStatus;
	/**
	 * @param product
	 * @param orderStatus
	 */
	public InventoryProductOrderStatus(Product product, String orderStatus) {
		super();
		this.product = product;
		this.orderStatus = orderStatus;
	}
	/**
	 * 
	 */
	public InventoryProductOrderStatus() {
		super();
	}
	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}
	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
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
}
