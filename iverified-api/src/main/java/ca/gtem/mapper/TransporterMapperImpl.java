package ca.gtem.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import ca.gtem.dto.TransporterDto;
import ca.gtem.model.Transporter;
import ca.gtem.repository.CityRepository;
import ca.gtem.util.ImageUtil;

@Component
public class TransporterMapperImpl implements TransporterMapper {
	private final CityRepository cityRepository;	
	
	@Value("${file.root-dir}")
	private String rootDir;	
	
	@Value("${file.transporter-dir}")
	private String transporterDir;
	
	/**
	 * @param cityService
	 * @param transporter
	 */
	public TransporterMapperImpl(CityRepository cityRepository) {		
		this.cityRepository = cityRepository;		
	}

	@Override
	public Transporter toEntity(TransporterDto transporterDto) {					
		Transporter transporter = new Transporter();		
		transporter.setId(transporterDto.getId());
		transporter.setName(transporterDto.getName());
		transporter.setAddress(transporterDto.getAddress());
		transporter.setEmail(transporterDto.getEmail());
		transporter.setPhone(transporterDto.getPhone());
		transporter.setWebAddress(transporterDto.getWebAddress());
		transporter.setAddress(transporterDto.getAddress());
		transporter.setPostcode(transporterDto.getPostcode());
		transporter.setShortDescription(transporterDto.getShortDescription());
		transporter.setLongDescription(transporterDto.getLongDescription());
		if (transporterDto.getLogoImage()!="") {
			transporter.setLogoImage(ImageUtil.storeImage(transporterDto.getLogoImage(),rootDir,transporterDir));	
		}
					
		if (transporterDto.getCity()!=null) {
			transporter.setCity(cityRepository.findOne(transporterDto.getCity()));
		}
		
		return transporter;
	}

	@Override
	public TransporterDto toDto(Transporter transporter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransporterDto> toDtos(List<Transporter> transporters) {
		// TODO Auto-generated method stub
		return null;
	}
}
