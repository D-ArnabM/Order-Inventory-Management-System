package com.orderinventory.dto;

import java.math.BigDecimal;

import com.orderinventory.entities.Product;
import com.orderinventory.entities.Store;

public class InventoryProductStoreShipmentStatusSum {
	private Product product;
	private Store store;
	private String shipmentStatus;
	private BigDecimal total;

	/**
	 * @param product
	 * @param store
	 * @param shipmentStatus
	 * @param total
	 */
	public InventoryProductStoreShipmentStatusSum(Product product, Store store, String shipmentStatus, BigDecimal total) {
		super();
		this.product = product;
		this.store = store;
		this.shipmentStatus = shipmentStatus;
		this.total = total;
	}

	/**
	 * 
	 */
	public InventoryProductStoreShipmentStatusSum() {
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
	 * @return the total
	 */
	public BigDecimal getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(BigDecimal total) {
		this.total = total;
	}

}
