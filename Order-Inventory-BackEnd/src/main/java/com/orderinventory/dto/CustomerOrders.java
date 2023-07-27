package com.orderinventory.dto;

import java.util.List;

import com.orderinventory.entities.Customer;
import com.orderinventory.entities.Order;

public class CustomerOrders {
	private Customer customer;
	private List<Order> order;
	/**
	 * @param customer
	 * @param order
	 */
	public CustomerOrders(Customer customer, List<Order> order) {
		super();
		this.customer = customer;
		this.order = order;
	}
	/**
	 * 
	 */
	public CustomerOrders() {
		super();
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
	 * @return the order
	 */
	public List<Order> getOrder() {
		return order;
	}
	/**
	 * @param order the order to set
	 */
	public void setOrder(List<Order> order) {
		this.order = order;
	}
	
	
}
