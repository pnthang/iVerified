package ca.gtem.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import ca.gtem.dto.ProducerDto;
import ca.gtem.model.Producer;
import ca.gtem.repository.CityRepository;
import ca.gtem.util.ImageUtil;

@Component
public class ProducerMapperImpl implements ProducerMapper {
	private final CityRepository cityRepository;	
	
	@Value("${file.root-dir}")
	private String rootDir;	
	
	@Value("${file.producer-dir}")
	private String producerDir;
	
	/**
	 * @param producerService
	 * @param producer
	 */
	public ProducerMapperImpl(CityRepository cityRepository) {		
		this.cityRepository = cityRepository;		
	}

	@Override
	public Producer toEntity(ProducerDto producerDto) {	
		Producer producer = new Producer();
		producer.setId(producerDto.getId());
		producer.setName(producerDto.getName());
		producer.setAddress(producerDto.getAddress());
		producer.setEmail(producerDto.getEmail());
		producer.setPhone(producerDto.getPhone());
		producer.setWebAddress(producerDto.getWebAddress());
		producer.setAddress(producerDto.getAddress());
		producer.setPostcode(producerDto.getPostcode());
		producer.setShortDescription(producerDto.getShortDescription());
		producer.setLongDescription(producerDto.getLongDescription());
		if (producerDto.getLogoImage()!="") {
			producer.setLogoImage(ImageUtil.storeImage(producerDto.getLogoImage(),rootDir,producerDir));	
		}
					
		if (producerDto.getCity()!=null) {
			producer.setCity(cityRepository.findOne(producerDto.getCity()));
		}
		
		return producer;
	}

	@Override
	public ProducerDto toDto(Producer producer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProducerDto> toDtos(List<Producer> products) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
