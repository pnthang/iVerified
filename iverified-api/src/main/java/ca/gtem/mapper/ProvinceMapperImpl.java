package ca.gtem.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import ca.gtem.dto.ProvinceDto;
import ca.gtem.model.Province;
import ca.gtem.repository.CountryRepository;

@Component
public class ProvinceMapperImpl implements ProvinceMapper {
	private final CountryRepository countryRepository;	
	
	
	/**
	 * @param countryService	 * 
	 */
	public ProvinceMapperImpl(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;	
	}

	@Override
	public Province toEntity(ProvinceDto provinceDto) {
		Province province = new Province();
		province.setId(provinceDto.getId());
		province.setName(provinceDto.getName());	
		if (provinceDto.getCountry()!=null) {
			province.setCountry(countryRepository.findOne(provinceDto.getCountry()));	
		}		
		return province;
	}

	@Override
	public ProvinceDto toDto(Province province) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProvinceDto> toDtos(List<Province> provinces) {
		// TODO Auto-generated method stub
		return null;
	}

}
