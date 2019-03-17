package ca.gtem.model;

import javax.validation.constraints.NotNull;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
  

@Entity

public class Product {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;
    
    @NotNull           
	private String name;
    
    @NotNull           
	private String sku;
    
    private String shortDescription;
    
    @Lob
    private String longDescription;
    
    private String thumbnailImages;
    
    private String largeImage;
    
    private String qrCodeImage;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_sub_category_id", nullable = false)
    private ProductSubCategory productSubCategory;    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id", nullable = false)
    private Seller seller;
    
    private double latitude;
    
    private double longitude;
    
    private boolean status;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the updatedAt
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the shortDescription
	 */
	public String getShortDescription() {
		return shortDescription;
	}

	/**
	 * @param shortDescription the shortDescription to set
	 */
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	/**
	 * @return the longDescription
	 */
	public String getLongDescription() {
		return longDescription;
	}

	/**
	 * @param longDescription the longDescription to set
	 */
	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	/**
	 * @return the thumbnailImages
	 */
	public String getThumbnailImages() {
		return thumbnailImages;
	}

	/**
	 * @param thumbnailImages the thumbnailImages to set
	 */
	public void setThumbnailImages(String thumbnailImages) {
		this.thumbnailImages = thumbnailImages;
	}

	/**
	 * @return the largeImage
	 */
	public String getImage() {
		return largeImage;
	}

	/**
	 * @param largeImage the largeImage to set
	 */
	public void setImage(String largeImage) {
		this.largeImage = largeImage;
	}

	/**
	 * @return the sku
	 */
	public String getSku() {
		return sku;
	}

	/**
	 * @param sku the sku to set
	 */
	public void setSku(String sku) {
		this.sku = sku;
	}

	/**
	 * @return the largeImage
	 */
	public String getLargeImage() {
		return largeImage;
	}

	/**
	 * @param largeImage the largeImage to set
	 */
	public void setLargeImage(String largeImage) {
		this.largeImage = largeImage;
	}

	/**
	 * @return the qrCodeImage
	 */
	public String getQrCodeImage() {
		return qrCodeImage;
	}

	/**
	 * @param qrCodeImage the qrCodeImage to set
	 */
	public void setQrCodeImage(String qrCodeImage) {
		this.qrCodeImage = qrCodeImage;
	}

	/**
	 * @return the productSubCategory
	 */
	public ProductSubCategory getProductSubCategory() {
		return productSubCategory;
	}

	/**
	 * @param productSubCategory the productSubCategory to set
	 */
	public void setProductSubCategory(ProductSubCategory productSubCategory) {
		this.productSubCategory = productSubCategory;
	}

	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longtitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longtitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	

}
