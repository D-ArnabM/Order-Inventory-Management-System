package com.orderinventory.entities;

import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "order_items", 
uniqueConstraints = {@UniqueConstraint(name = "order_items_product_u", columnNames = {"product_id", "orders_id"})})
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name ="orders_id", referencedColumnName = "order_id", nullable = false)
	private Order order;
	
	@Column(name = "line_item_id", nullable = false)
	private int lineItemId;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
	private Product product;

	@Column(name = "unit_price", nullable = false, precision = 10, scale = 2)
	private BigDecimal unitPrice;

	@Column(name = "quantity", nullable = false)
	private int quantity;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "shipment_id")
	private Shipment shipment;
	
	/**
	 * 
	 */
	public OrderItem() {
		super();
	}

	/**
	 * Constructor with order, lineItemId, product, unitPrice, quantity, shipment
	 * @param order		id of Order
	 * @param lineItemId	id of line item
	 * @param product		id of Product
	 * @param unitPrice		Price of unit
	 * @param quantity		Quantity of order items
	 * @param shipment	id of shipment
	 */
	public OrderItem(Order order, int lineItemId, Product product, BigDecimal unitPrice, int quantity,
			Shipment shipment) {
		super();
		this.order = order;
		this.lineItemId = lineItemId;
		this.product = product;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.shipment = shipment;
	}
	
	
	/**
	 * Constructor with order, lineItemId, product, unitPrice, quantity, shipment
	 * @param order		id of Order
	 * @param lineItemId	id of line item
	 * @param product		id of Product
	 * @param unitPrice		Price of unit
	 * @param quantity		Quantity of order items
	 * @param shipment	id of shipment
	 */
	public OrderItem(int id, Order order, int lineItemId, Product product, BigDecimal unitPrice, int quantity,
			Shipment shipment) {
		super();
		this.id = id;
		this.order = order;
		this.lineItemId = lineItemId;
		this.product = product;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.shipment = shipment;
	}
	

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * @return the lineItemId
	 */
	public int getLineItemId() {
		return lineItemId;
	}

	/**
	 * @param lineItemId the lineItemId to set
	 */
	public void setLineItemId(int lineItemId) {
		this.lineItemId = lineItemId;
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
	 * @return the unitPrice
	 */
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the shipment
	 */
	public Shipment getShipmentId() {
		return shipment;
	}

	/**
	 * @param shipment the shipment to set
	 */
	public void setShipmentId(Shipment shipment) {
		this.shipment = shipment;
	}
	
}
