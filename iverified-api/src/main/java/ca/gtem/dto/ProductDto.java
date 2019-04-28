package ca.gtem.dto;

import java.util.Date;

public class ProductDto {
	private Long id;
	
	private String name;
    
    private Date productionDate;
    
    private Date expirationDate;
    
    private String address;
	
	private String postcode;	
    
	private String sku;
    
    private String shortDescription;
        
    private String longDescription;
    
    private String thumbnailImages;
    
    private String largeImage;
    
    private String qrCodeImage;    
    
    private double latitude;
    
    private double longitude;
    
    private boolean status;
        
    private Long productCategory;    
     
    private Long producer;
       
    private Long city;
    
    private String hash;

    
	/**
	 * @return the productCategory
	 */
	public Long getProductCategory() {
		return productCategory;
	}

	/**
	 * @param productCategory the productCategory to set
	 */
	public void setProductCategory(Long productCategory) {
		this.productCategory = productCategory;
	}

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
	 * @return the productionDate
	 */
	public Date getProductionDate() {
		return productionDate;
	}

	/**
	 * @param productionDate the productionDate to set
	 */
	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}

	/**
	 * @return the expirationDate
	 */
	public Date getExpirationDate() {
		return expirationDate;
	}

	/**
	 * @param expirationDate the expirationDate to set
	 */
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the postcode
	 */
	public String getPostcode() {
		return postcode;
	}

	/**
	 * @param postcode the postcode to set
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
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
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitude) {
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



	/**
	 * @return the producerId
	 */
	public Long getProducer() {
		return producer;
	}

	/**
	 * @param producerId the producerId to set
	 */
	public void setProducer(Long producer) {
		this.producer = producer;
	}

	/**
	 * @return the cityId
	 */
	public Long getCity() {
		return city;
	}

	/**
	 * @param cityId the cityId to set
	 */
	public void setCity(Long city) {
		this.city = city;
	}

	/**
	 * @return the hash
	 */
	public String getHash() {
		return hash;
	}

	/**
	 * @param hash the hash to set
	 */
	public void setHash(String hash) {
		this.hash = hash;
	}

}
