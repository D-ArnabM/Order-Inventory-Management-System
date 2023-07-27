package com.orderinventory.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import java.util.Date;

import org.hibernate.annotations.Check;

@Entity
@Table(name = "stores",
uniqueConstraints = {@UniqueConstraint(name = "store_name_u", columnNames = {"store_name"})})
@Check(name="store_at_least_one_address_c",constraints = "web_address IS NOT NULL OR physical_address IS NOT NULL")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private int storeId;

    @Column(name = "store_name", nullable = false, unique = true)
    private String storeName;

    @Column(name = "web_address", length = 100)
    private String webAddress;

    @Column(name = "physical_address", length = 512)
    private String physicalAddress;

    @Column(name = "latitude", precision = 9, scale = 6)
    private BigDecimal latitude;

    @Column(name = "longitude", precision = 9, scale = 6)
    private BigDecimal longitude;

    @Column(name = "logo_mime_type", length = 512)
    private String logoMimeType;

    @Column(name = "logo_filename", length = 512)
    private String logoFilename;

    @Column(name = "logo_charset", length = 512)
    private String logoCharset;

    @Temporal(TemporalType.DATE)
    @Column(name = "logo_last_updated")
    private Date logoLastUpdated;

    // Constructors

    /**
     * Default constructor for the Store entity.
     */
    public Store() {
        // Default constructor
    }


    /**
	 * @param storeId
	 * @param storeName
	 * @param webAddress
	 * @param physicalAddress
	 * @param latitude
	 * @param longitude
	 * @param logoMimeType
	 * @param logoFilename
	 * @param logoCharset
	 * @param logoLastUpdated
	 */
	public Store(int storeId, String storeName, String webAddress, String physicalAddress, BigDecimal latitude,
			BigDecimal longitude, String logoMimeType, String logoFilename, String logoCharset,
			Date logoLastUpdated) {
		super();
		this.storeId = storeId;
		this.storeName = storeName;
		this.webAddress = webAddress;
		this.physicalAddress = physicalAddress;
		this.latitude = latitude;
		this.longitude = longitude;
		this.logoMimeType = logoMimeType;
		this.logoFilename = logoFilename;
		this.logoCharset = logoCharset;
		this.logoLastUpdated = logoLastUpdated;
	}


	// Getters and Setters
	
    /**
     * Retrieves the store ID.
     *
     * @return the store ID
     */
    public int getStoreId() {
        return storeId;
    }


	/**
     * Sets the store ID.
     *
     * @param storeId the store ID to set
     */
    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    /**
     * Retrieves the store name.
     *
     * @return the store name
     */
    public String getStoreName() {
        return storeName;
    }

    /**
     * Sets the store name.
     *
     * @param storeName the store name to set
     */
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    /**
     * Retrieves the web address of the store.
     *
     * @return the web address
     */
    public String getWebAddress() {
        return webAddress;
    }

    /**
     * Sets the web address of the store.
     *
     * @param webAddress the web address to set
     */
    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    /**
     * Retrieves the physical address of the store.
     *
     * @return the physical address
     */
    public String getPhysicalAddress() {
        return physicalAddress;
    }

    /**
     * Sets the physical address of the store.
     *
     * @param physicalAddress the physical address to set
     */
    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    /**
     * Retrieves the latitude of the store's location.
     *
     * @return the latitude
     */
    public BigDecimal getLatitude() {
        return latitude;
    }

    /**
     * Sets the latitude of the store's location.
     *
     * @param latitude the latitude to set
     */
    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    /**
     * Retrieves the longitude of the store's location.
     *
     * @return the longitude
     */
    public BigDecimal getLongitude() {
        return longitude;
    }

    /**
     * Sets the longitude of the store's location.
     *
     * @param longitude the longitude to set
     */
    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }



    /**
     * Retrieves the MIME type of the logo.
     *
     * @return the logo MIME type
     */
    public String getLogoMimeType() {
        return logoMimeType;
    }

    /**
     * Sets the MIME type of the logo.
     *
     * @param logoMimeType the logo MIME type to set
     */
    public void setLogoMimeType(String logoMimeType) {
        this.logoMimeType = logoMimeType;
    }

    /**
     * Retrieves the filename of the logo.
     *
     * @return the logo filename
     */
    public String getLogoFilename() {
        return logoFilename;
    }

    /**
     * Sets the filename of the logo.
     *
     * @param logoFilename the logo filename to set
     */
    public void setLogoFilename(String logoFilename) {
        this.logoFilename = logoFilename;
    }

    /**
     * Retrieves the charset of the logo.
     *
     * @return the logo charset
     */
    public String getLogoCharset() {
        return logoCharset;
    }

    /**
     * Sets the charset of the logo.
     *
     * @param logoCharset the logo charset to set
     */
    public void setLogoCharset(String logoCharset) {
        this.logoCharset = logoCharset;
    }

    /**
     * Retrieves the last updated date of the logo.
     *
     * @return the logo last updated date
     */
    public Date getLogoLastUpdated() {
        return logoLastUpdated;
    }

    /**
     * Sets the last updated date of the logo.
     *
     * @param logoLastUpdated the logo last updated date to set
     */
    public void setLogoLastUpdated(Date logoLastUpdated) {
        this.logoLastUpdated = logoLastUpdated;
    }
}
