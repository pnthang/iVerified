package ca.gtem.dto;

public class CityDto {
	private Long id;
	
	private String name;
	
	private Long province;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
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
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the provinceId
	 */
	public Long getProvince() {
		return province;
	}

	/**
	 * @param provinceId the provinceId to set
	 */
	public void setProvince(Long province) {
		this.province = province;
	}
	
	
}
