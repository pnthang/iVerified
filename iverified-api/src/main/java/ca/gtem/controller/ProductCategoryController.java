package ca.gtem.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.gtem.model.ProductCategory;
import ca.gtem.repository.ProductCategoryRepository;
import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping(path = "/api")
public class ProductCategoryController {
	private final ProductCategoryRepository productCategoryRepository;
	
	/**
	 * @param productCategoryRepository
	 */
	public ProductCategoryController(ProductCategoryRepository productCategoryRepository) {	
		this.productCategoryRepository = productCategoryRepository;
	}

	@GetMapping("/product-categories")
	public Page<ProductCategory> getList(Pageable pageable){				
		if(pageable == null){
			return this.productCategoryRepository.findAll(pageable);
	    }else {
	    	int page;
	    	page = pageable.getPageNumber() -1;
	    	Pageable query_pageable = new PageRequest(page>0? page:0,pageable.getPageSize(),pageable.getSort());
			return this.productCategoryRepository.findAll(query_pageable);
	    } 		
	}
	
	@GetMapping("/product-category/{id}")
	public ProductCategory find(@PathVariable("id") Long id) {
		return productCategoryRepository.findOne(id);
	}
	
	@PostMapping("/product-category")
	public ProductCategory create(@RequestBody ProductCategory productCategory) {		
		return productCategoryRepository.save(productCategory);		
	}
	
	@DeleteMapping("/product-category/{id}")
	public void delete(@PathVariable("id") Long id) {
		productCategoryRepository.delete(id);
	}
	
	@PutMapping("/product-category")
	public ProductCategory update(@RequestBody ProductCategory productCategory) throws BadHttpRequest  {
		if (productCategoryRepository.exists(productCategory.getId())) {
			//country.setId(id);
			return productCategoryRepository.save(productCategory);
		} else {
			throw new BadHttpRequest();
		}
	}
}
