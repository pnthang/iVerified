package ca.gtem.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.gtem.model.Product;
import ca.gtem.repository.ProductRepository;
import ca.gtem.dto.ProductDto;
import ca.gtem.mapper.ProductMapper;

import ca.gtem.util.ImageUtil;

import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping(path = "/api")
public class ProductController {	
	private final ProductRepository productRepository;	
	private final ProductMapper productMapper;
	
	@Value("${file.root-dir}")
	private String rootDir;	
	
	@Value("${file.product-dir}")
	private String productDir;
	
	
	/**
	 * @param productService
	 * @param productMapper
	 */
	public ProductController(ProductRepository productRepository, ProductMapper productMapper) {
		super();
		this.productRepository = productRepository;
		this.productMapper = productMapper;
	}

	@GetMapping("/products")
	public Page<Product> getList(Pageable pageable){				
		if(pageable == null){
			return this.productRepository.findAll(pageable);
	    }else {
	    	int page;
	    	page = pageable.getPageNumber() -1;
	    	Pageable query_pageable = new PageRequest(page>0? page:0,pageable.getPageSize(),pageable.getSort());
			return this.productRepository.findAll(query_pageable);
	    } 		
	}
	
	@GetMapping("/product/{id}")
	public Product find(@PathVariable("id") Long id) {
		return productRepository.findOne(id);
	}
	
	@GetMapping("/product/sku/{sku}")	
	public Product findBySku(@PathVariable("sku") String sku) {
		return productRepository.findBySku(sku);
	}
	
	@GetMapping("/product/code/{hash}")	
	public Product findByHash(@PathVariable("hash") String hash) {
		return productRepository.findByHash(hash);
	}
	
	@PostMapping("/product")	
	public ResponseEntity<ProductDto> create(@RequestBody ProductDto productDto) {				
		productRepository.save(productMapper.toEntity(productDto));		
		return ResponseEntity.status(HttpStatus.CREATED).body(productDto);
	}
	
	@DeleteMapping("/product/{id}")
	public void delete(@PathVariable("id") Long id) {
		Product product = productRepository.findOne(id);
		ImageUtil.deleteImage(product.getThumbnailImages(), rootDir + productDir);
		ImageUtil.deleteImage(product.getLargeImage(), rootDir + productDir);
		productRepository.delete(id);
	}
	
	@PutMapping("/product")
	public ResponseEntity<ProductDto> update(@RequestBody ProductDto productDto) throws BadHttpRequest  {
		if (productRepository.exists(productDto.getId())) {
			//product.setId(id);
			productRepository.save(productMapper.toEntity(productDto));		
			return ResponseEntity.status(HttpStatus.CREATED).body(productDto);
		} else {
			throw new BadHttpRequest();
		}
	}

}
