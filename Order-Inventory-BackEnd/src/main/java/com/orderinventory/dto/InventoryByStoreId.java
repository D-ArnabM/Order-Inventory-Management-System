package com.orderinventory.dto;

import com.orderinventory.entities.Product;
import com.orderinventory.entities.Store;

public class InventoryByStoreId {
	private Product product;
	private Store store;
	private String orderStatus;
	/**
	 * @param product
	 * @param store
	 * @param orderStatus
	 */
	public InventoryByStoreId(Product product, Store store, String orderStatus) {
		super();
		this.product = product;
		this.store = store;
		this.orderStatus = orderStatus;
	}
	/**
	 * 
	 */
	public InventoryByStoreId() {
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
	 * @return the store
	 */
	public Store getStore() {
		return store;
	}
	/**
	 * @param store the store to set
	 */
	public void setStore(Store store) {
		this.store = store;
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
