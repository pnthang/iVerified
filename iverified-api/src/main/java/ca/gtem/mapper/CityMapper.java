package ca.gtem.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import ca.gtem.dto.CityDto;
import ca.gtem.model.City;

@Component
public interface CityMapper {
	City toEntity(CityDto cityDto);	
	CityDto toDto(City city);
	List<CityDto> toDtos(List<City> Cities);	
}
