package ca.gtem.dto;

public class ProvinceDto {	
	private Long id;
	
	private String name;
	
	private Long country;

		
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
	 * @return the countryId
	 */
	public Long getCountry() {
		return country;
	}

	/**
	 * @param countryId the countryId to set
	 */
	public void setCountry(Long country) {
		this.country = country;
	}
	
	
	
}
