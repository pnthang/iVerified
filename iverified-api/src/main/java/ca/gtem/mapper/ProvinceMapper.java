package ca.gtem.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import ca.gtem.dto.ProvinceDto;
import ca.gtem.model.Province;

@Component
public interface ProvinceMapper {
	Province toEntity(ProvinceDto provinceDto);	
	ProvinceDto toDto(Province province);
	List<ProvinceDto> toDtos(List<Province> provinces);	
}
