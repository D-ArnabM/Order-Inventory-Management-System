package com.orderinventory.dto;

import java.util.List;
import com.orderinventory.entities.Customer;
import com.orderinventory.entities.Shipment;

public class CustomerShipment {
	private Customer customer;
	private List<Shipment> shipment;
	/**
	 * @param customer
	 * @param shipment
	 */
	public CustomerShipment(Customer customer, List<Shipment> shipment) {
		super();
		this.customer = customer;
		this.shipment = shipment;
	}
	/**
	 * 
	 */
	public CustomerShipment() {
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
	 * @return the shipment
	 */
	public List<Shipment> getShipment() {
		return shipment;
	}
	/**
	 * @param shipment the shipment to set
	 */
	public void setShipment(List<Shipment> shipment) {
		this.shipment = shipment;
	}
	
	
}
