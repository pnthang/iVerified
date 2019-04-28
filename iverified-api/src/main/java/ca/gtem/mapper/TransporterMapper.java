package ca.gtem.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import ca.gtem.dto.TransporterDto;
import ca.gtem.model.Transporter;

@Component
public interface TransporterMapper {
	Transporter toEntity(TransporterDto transporterDto);	
	TransporterDto toDto(Transporter transporter);
	List<TransporterDto> toDtos(List<Transporter> transporters);	
}
