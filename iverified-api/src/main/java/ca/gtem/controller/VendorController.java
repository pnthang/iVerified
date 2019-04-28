package ca.gtem.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.gtem.model.Producer;
import ca.gtem.model.Vendor;
import ca.gtem.repository.VendorRepository;

@RestController
@RequestMapping(path = "/api")
public class VendorController {
	private final VendorRepository vendorRepository;

	/**
	 * @param vendorRepository
	 */
	public VendorController(VendorRepository vendorRepository) {		
		this.vendorRepository = vendorRepository;
	}
	
	@GetMapping("/vendors")
	public Page<Vendor> getList(Pageable pageable){				
		if(pageable == null){
			return this.vendorRepository.findAll(pageable);
	    }else {
	    	int page;
	    	page = pageable.getPageNumber() -1;
	    	Pageable query_pageable = new PageRequest(page>0? page:0,pageable.getPageSize(),pageable.getSort());
			return this.vendorRepository.findAll(query_pageable);
	    } 		
	}
	
}
