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

import ca.gtem.dto.SupplierDto;
import ca.gtem.mapper.SupplierMapper;
import ca.gtem.model.Supplier;
import ca.gtem.repository.SupplierRepository;
import ca.gtem.util.ImageUtil;
import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping("/api")
public class SupplierController {
	private final SupplierRepository supplierRepository;	
	private final SupplierMapper supplierMapper;

	@Value("${file.root-dir}")
	private String rootDir;	
	
	@Value("${file.supplier-dir}")
	private String supplierDir;
	
	/**
	 * @param supplierRepository
	 * @param producerMapper
	 */
	public SupplierController(SupplierRepository supplierRepository, SupplierMapper supplierMapper) {		
		this.supplierRepository = supplierRepository;
		this.supplierMapper = supplierMapper;
	}

	@GetMapping("/suppliers")
	public Page<Supplier> getList(Pageable pageable){				
		if(pageable == null){
			return this.supplierRepository.findAll(pageable);
	    }else {
	    	int page;
	    	page = pageable.getPageNumber() -1;
	    	Pageable query_pageable = new PageRequest(page>0? page:0,pageable.getPageSize(),pageable.getSort());
			return this.supplierRepository.findAll(query_pageable);
	    } 		
	}
	
	@GetMapping("/supplier/{id}")
	public Supplier find(@PathVariable("id") Long id) {
		return supplierRepository.findOne(id);
	}
	
	@PostMapping("/supplier")	
	public ResponseEntity<SupplierDto> create(@RequestBody SupplierDto supplierDto) {				
		supplierRepository.save(supplierMapper.toEntity(supplierDto));		
		return ResponseEntity.status(HttpStatus.CREATED).body(supplierDto);
	}
	
	@DeleteMapping("/supplier/{id}")
	public void delete(@PathVariable("id") Long id) {
		Supplier supplier = supplierRepository.findOne(id);
		ImageUtil.deleteImage(supplier.getLogoImage(), rootDir + supplierDir);
		supplierRepository.delete(id);
	}
	
	@PutMapping("/supplier")
	public ResponseEntity<SupplierDto> update(@RequestBody SupplierDto supplierDto) throws BadHttpRequest  {
		if (supplierRepository.exists(supplierDto.getId())) {
			//producer.setId(id);
			supplierRepository.save(supplierMapper.toEntity(supplierDto));		
			return ResponseEntity.status(HttpStatus.CREATED).body(supplierDto);
		} else {
			throw new BadHttpRequest();
		}
	}
}
