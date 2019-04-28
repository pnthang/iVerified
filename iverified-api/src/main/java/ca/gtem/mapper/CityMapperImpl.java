package ca.gtem.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import ca.gtem.dto.CityDto;
import ca.gtem.model.City;
import ca.gtem.repository.ProvinceRepository;

@Component
public class CityMapperImpl implements CityMapper {
	private final ProvinceRepository provinceRepository;		

	/**
	 * @param provinceService
	 * 
	 */
	public CityMapperImpl(ProvinceRepository provinceRepository) {
		this.provinceRepository = provinceRepository;		
	}

	@Override
	public City toEntity(CityDto cityDto) {
		City city = new City();
		city.setId(cityDto.getId());
		city.setName(cityDto.getName());	
		if (cityDto.getProvince()!=null) {
			city.setProvince(provinceRepository.findOne(cityDto.getProvince()));
		}
		
		return city;
	}

	@Override
	public CityDto toDto(City city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CityDto> toDtos(List<City> Cities) {
		// TODO Auto-generated method stub
		return null;
	}

}
