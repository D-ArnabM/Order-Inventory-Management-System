package com.orderinventory.dto;

import java.util.List;

import com.orderinventory.entities.Store;

public class InventoryStoreProductOrderStatus {
	private Store store;
	private List<Object[]> object;
	/**
	 * @param store
	 * @param object
	 */
	public InventoryStoreProductOrderStatus(Store store, List<Object[]> object) {
		super();
		this.store = store;
		this.object = object;
	}
	/**
	 * 
	 */
	public InventoryStoreProductOrderStatus() {
		super();
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
	 * @return the object
	 */
	public List<Object[]> getObject() {
		return object;
	}
	/**
	 * @param object the object to set
	 */
	public void setObject(List<Object[]> object) {
		this.object = object;
	}
	
}
