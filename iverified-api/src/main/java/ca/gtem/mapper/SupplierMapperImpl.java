package ca.gtem.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import ca.gtem.dto.SupplierDto;
import ca.gtem.model.Supplier;
import ca.gtem.repository.CityRepository;
import ca.gtem.util.ImageUtil;

@Component
public class SupplierMapperImpl implements SupplierMapper {
	private final CityRepository cityRepository;	
	
	@Value("${file.root-dir}")
	private String rootDir;	
	
	@Value("${file.supplier-dir}")
	private String supplierDir;
		
	/**
	 * @param cityService
	 * @param supplier
	 */
	public SupplierMapperImpl(CityRepository cityRepository) {		
		this.cityRepository = cityRepository;		
	}

	@Override
	public Supplier toEntity(SupplierDto supplierDto) {	
		Supplier supplier = new Supplier();		
		supplier.setId(supplierDto.getId());
		supplier.setName(supplierDto.getName());
		supplier.setAddress(supplierDto.getAddress());
		supplier.setEmail(supplierDto.getEmail());
		supplier.setPhone(supplierDto.getPhone());
		supplier.setWebAddress(supplierDto.getWebAddress());
		supplier.setAddress(supplierDto.getAddress());
		supplier.setPostcode(supplierDto.getPostcode());
		supplier.setShortDescription(supplierDto.getShortDescription());
		supplier.setLongDescription(supplierDto.getLongDescription());
		if (supplierDto.getLogoImage()!="") {
			supplier.setLogoImage(ImageUtil.storeImage(supplierDto.getLogoImage(),rootDir,supplierDir));	
		}
					
		if (supplierDto.getCity()!=null) {
			supplier.setCity(cityRepository.findOne(supplierDto.getCity()));
		}
		
		return supplier;
	}

	@Override
	public SupplierDto toDto(Supplier supplier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SupplierDto> toDtos(List<Supplier> suppliers) {
		// TODO Auto-generated method stub
		return null;
	}
}
