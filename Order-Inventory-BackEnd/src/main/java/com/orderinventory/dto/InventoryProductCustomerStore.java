package com.orderinventory.dto;

import com.orderinventory.entities.Customer;
import com.orderinventory.entities.Product;
import com.orderinventory.entities.Store;

public class InventoryProductCustomerStore {
	private Product product;
	private Customer customer;
	private Store store;
	/**
	 * @param product
	 * @param customer
	 * @param store
	 */
	public InventoryProductCustomerStore(Product product, Customer customer, Store store) {
		super();
		this.product = product;
		this.customer = customer;
		this.store = store;
	}
	/**
	 * 
	 */
	public InventoryProductCustomerStore() {
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
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}
	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
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
}
