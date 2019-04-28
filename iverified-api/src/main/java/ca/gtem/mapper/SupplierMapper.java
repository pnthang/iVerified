package ca.gtem.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import ca.gtem.dto.SupplierDto;
import ca.gtem.model.Supplier;

@Component
public interface SupplierMapper {
	Supplier toEntity(SupplierDto producerDto);	
	SupplierDto toDto(Supplier supplier);
	List<SupplierDto> toDtos(List<Supplier> suppliers);	
}
