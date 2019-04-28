package ca.gtem.dto;

import ca.gtem.model.Vendor;

public class BlockDto {
	private Long id;	
	               
	private String name;
    
	private Long product;
	
	private String description;
    
    private String hash;
    
    private String previousHash;
    
    private String image;
    
    private Long previousBlock;
    
    private Long source;
    
    private Long destination;

        
	/**
	 * @return the previousBlock
	 */
	public Long getPreviousBlock() {
		return previousBlock;
	}

	/**
	 * @param previousBlock the previousBlock to set
	 */
	public void setPreviousBlock(Long previousBlock) {
		this.previousBlock = previousBlock;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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

	/**
	 * @return the previousHash
	 */
	public String getPreviousHash() {
		return previousHash;
	}

	/**
	 * @param previousHash the previousHash to set
	 */
	public void setPreviousHash(String previousHash) {
		this.previousHash = previousHash;
	}

	/**
	 * @return the source
	 */
	public Long getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(Long source) {
		this.source = source;
	}

	/**
	 * @return the destination
	 */
	public Long getDestination() {
		return destination;
	}

	/**
	 * @param destination the destination to set
	 */
	public void setDestination(Long destination) {
		this.destination = destination;
	}

	/**
	 * @return the product
	 */
	public Long getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Long product) {
		this.product = product;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
    
    
}
