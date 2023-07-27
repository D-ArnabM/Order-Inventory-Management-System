package com.orderinventory.entities;

import jakarta.persistence.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "inventory",
        indexes = {@Index(name = "inventory_product_id_fk", columnList = "product_id")})
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private int inventoryId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "store_id", referencedColumnName = "store_id", nullable = false)
    private Store store;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
    private Product product;

    @Column(name = "product_inventory", nullable = false)
    private int productInventory;

    // Constructors, getters, and setters

    /**
     * Default constructor.
     */
    public Inventory() {
        // Default constructor
    }

    /**
     * Constructor with store, product and product inventory.
     *
     * @param inventoryId     The id associated with the inventory.
     * @param store           The store associated with the inventory.
     * @param product         The product associated with the inventory.
     * @param productInventory The product inventory count.
     */
    public Inventory(Store store, Product product, int productInventory) {
        this.store = store;
        this.product = product;
        this.productInventory = productInventory;
    }
    /**
     * Constructor with all fields.
     *
     * @param store           The store associated with the inventory.
     * @param product         The product associated with the inventory.
     * @param productInventory The product inventory count.
     */
    public Inventory(int inventoryId, Store store, Product product, int productInventory) {
    	this.inventoryId = inventoryId;
        this.store = store;
        this.product = product;
        this.productInventory = productInventory;
    }

    /**
     * Gets the inventory ID.
     *
     * @return The inventory ID.
     */
    public int getInventoryId() {
        return inventoryId;
    }

    /**
     * Sets the inventory ID.
     *
     * @param inventoryId The inventory ID to set.
     */
    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    /**
     * Gets the store associated with the inventory.
     *
     * @return The store associated with the inventory.
     */
    public Store getStore() {
        return store;
    }

    /**
     * Sets the store associated with the inventory.
     *
     * @param store The store to set.
     */
    public void setStore(Store store) {
        this.store = store;
    }

    /**
     * Gets the product associated with the inventory.
     *
     * @return The product associated with the inventory.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets the product associated with the inventory.
     *
     * @param product The product to set.
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Gets the product inventory count.
     *
     * @return The product inventory count.
     */
    public int getProductInventory() {
        return productInventory;
    }

    /**
     * Sets the product inventory count.
     *
     * @param productInventory The product inventory count to set.
     */
    public void setProductInventory(int productInventory) {
        this.productInventory = productInventory;
    }
}