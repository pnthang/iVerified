package ca.gtem.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import ca.gtem.model.Producer;
import ca.gtem.dto.ProducerDto;

@Component
public interface ProducerMapper {		
	Producer toEntity(ProducerDto producerDto);	
	ProducerDto toDto(Producer producer);
	List<ProducerDto> toDtos(List<Producer> products);				
}
