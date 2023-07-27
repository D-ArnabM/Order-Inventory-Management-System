package com.orderinventory.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "email_address", unique = true, nullable = false)
    private String emailAddress;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    /**
     * Default constructor
     */
    public Customer() {
        // Default constructor
    }

    /**
     * Constructor with email address and full name
     *
     * @param emailAddress the email address of the customer
     * @param fullName     the full name of the customer
     */
    public Customer(String emailAddress, String fullName) {
        this.emailAddress = emailAddress;
        this.fullName = fullName;
    }
    

    /**
     * Constructor with all the fields
     * 
	 * @param customerId   the id of the customer
	 * @param emailAddress the email address of the customer
	 * @param fullName	   the full name of the customer
	 */
	public Customer(int customerId, String emailAddress, String fullName) {
		super();
		this.customerId = customerId;
		this.emailAddress = emailAddress;
		this.fullName = fullName;
	}

	/**
     * Get the customer ID
     *
     * @return the customer ID
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * Set the customer ID
     *
     * @param customerId the customer ID to set
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * Get the email address of the customer
     *
     * @return the email address
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Set the email address of the customer
     *
     * @param emailAddress the email address to set
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Get the full name of the customer
     *
     * @return the full name
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Set the full name of the customer
     *
     * @param fullName the full name to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
