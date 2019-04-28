package ca.gtem.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ca.gtem.dto.ProvinceDto;
import ca.gtem.mapper.ProvinceMapper;
import ca.gtem.model.Province;
import ca.gtem.repository.ProvinceRepository;
import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping("/api")
public class ProvinceController {
	//private final ProvinceService provinceService;
	private final ProvinceMapper provinceMapper;
	private final ProvinceRepository provinceRepository;
	/**
	 * @param cityService
	 * @param provinceMapper
	 */
	public ProvinceController(ProvinceRepository provinceRepository, ProvinceMapper provinceMapper) {	
		this.provinceRepository = provinceRepository;
		this.provinceMapper = provinceMapper;
	}

	@GetMapping("/provinces")
	public Page<Province> getList(Pageable pageable){				
		if(pageable == null){
			return this.provinceRepository.findAll(pageable);
	    }else {
	    	int page;
	    	page = pageable.getPageNumber() -1;
	    	Pageable query_pageable = new PageRequest(page>0? page:0,pageable.getPageSize(),pageable.getSort());
			return this.provinceRepository.findAll(query_pageable);
	    } 		
	}
	
	@GetMapping("/country/{countryId}/provinces")
	public  Page<Province> getListProvinceByCountryId(@PathVariable("countryId") Long countryId, Pageable pageable) {
		if(pageable == null){
			return this.provinceRepository.findByCountryId(countryId, pageable);
	    }else {
	    	int page = pageable.getPageNumber()==0? pageable.getPageNumber(): pageable.getPageNumber() -1;
	    	Pageable query_pageable = new PageRequest(page>0? page:0,pageable.getPageSize(),pageable.getSort());
			return this.provinceRepository.findByCountryId(countryId, query_pageable);
	    } 		
	}
	
	@GetMapping("/province/{id}")
	public Province find(@PathVariable("id") Long id) {
		return provinceRepository.findOne(id);
	}
		
	
	@PostMapping("/province")
	public ResponseEntity<ProvinceDto> create(@RequestBody ProvinceDto provinceDto) {				
		provinceRepository.save(provinceMapper.toEntity(provinceDto));		
		return ResponseEntity.status(HttpStatus.CREATED).body(provinceDto);
	}
	
	@DeleteMapping("/province/{id}")
	public void delete(@PathVariable("id") Long id) {
		provinceRepository.delete(id);
	}
	
	@PutMapping("/province")
	public ResponseEntity<ProvinceDto> update(@RequestBody ProvinceDto provinceDto) throws BadHttpRequest  {			
		if (provinceRepository.exists(provinceDto.getId())) {
			//country.setId(id);
			provinceRepository.save(provinceMapper.toEntity(provinceDto));		
			return ResponseEntity.status(HttpStatus.CREATED).body(provinceDto);
		} else {
			throw new BadHttpRequest();
		}
	}

}
