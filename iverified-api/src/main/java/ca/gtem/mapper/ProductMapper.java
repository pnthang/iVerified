package ca.gtem.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import ca.gtem.dto.ProductDto;
import ca.gtem.model.Product;

@Component
public interface ProductMapper {
	
	ProductDto toDto(Product product);
    List<ProductDto> toDtos(List<Product> products);
    Product toEntity(ProductDto productDto);
}
