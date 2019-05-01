package ca.gtem.mapper;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.zxing.WriterException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import ca.gtem.dto.ProductDto;
import ca.gtem.model.Product;
import ca.gtem.repository.CityRepository;
import ca.gtem.repository.ProducerRepository;
import ca.gtem.repository.ProductCategoryRepository;

import ca.gtem.util.QRCodeGenerator;
import ca.gtem.util.StringUtil;
import ca.gtem.util.ImageUtil;

@Component
public class ProductMapperImpl implements ProductMapper {	
	private final CityRepository cityRepository;	
	private final ProducerRepository producerRepository;
	private final ProductCategoryRepository productCategoryRepository;
	private final ServletContext context;
	
	@Value("${user.running.domain}")
	private String domain;
	
	@Value("${file.root-dir}")
	private String rootDir;	
	
	@Value("${file.product-dir}")
	private String productDir;
	
	@Value("${file.qrimage-dir}")
	private String qrimageDir;
	
	/**
	 * @param cityService
	 * @param producerService
	 * @param productSubCategoryService
	 */
	public ProductMapperImpl(CityRepository cityRepository, ProducerRepository producerRepository,
			ProductCategoryRepository productCategoryRepository,
			ServletContext context) {		
		this.cityRepository = cityRepository;
		this.producerRepository = producerRepository;
		this.productCategoryRepository = productCategoryRepository;	
		this.context = context;
	}

	@Override
	public ProductDto toDto(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDto> toDtos(List<Product> products) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product toEntity(ProductDto productDto) {
		Product product = new Product();
		product.setId(productDto.getId());
		product.setName(productDto.getName());
		product.setShortDescription(productDto.getShortDescription());
		product.setLongDescription(productDto.getLongDescription());
		if (productDto.getThumbnailImages()!="") {
			product.setThumbnailImages(ImageUtil.storeImage(productDto.getThumbnailImages(),rootDir,productDir));	
		}		
		//product.setLargeImage(ImageUtil.storeImage(productDto.getLargeImage(),rootDir,productDir));
		product.setLatitude(productDto.getLatitude());
		product.setLongitude(productDto.getLongitude());
		product.setProductionDate(productDto.getProductionDate());
		product.setExpirationDate(productDto.getExpirationDate());
		product.setSku(productDto.getSku().toUpperCase());
		product.setAddress(productDto.getAddress());
		product.setPostcode(productDto.getPostcode());
		if (productDto.getCity()!=null) {
			product.setCity(cityRepository.findOne(productDto.getCity()));
		}
		if (productDto.getProducer()!=null) {
			product.setProducer(producerRepository.findOne(productDto.getProducer()));
		}
		if (productDto.getProductCategory()!=null) {
			product.setProductCategory(productCategoryRepository.findOne(productDto.getProductCategory()));
		}
										
		productDto.setHash(StringUtil.createHash(productDto.getName()));
		product.setHash(productDto.getHash());
		
		product.setQrCodeImage(QRCodeGenerator.createQrCode(productDto.getName(),
					domain,
					productDto.getHash(),
					rootDir,
					qrimageDir
			));			
				
		return product;
	}

}
