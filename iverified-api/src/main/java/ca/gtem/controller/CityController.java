package ca.gtem.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
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

import ca.gtem.dto.CityDto;
import ca.gtem.mapper.CityMapper;
import ca.gtem.model.City;
import ca.gtem.repository.CityRepository;
import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping(path = "/api")
public class CityController {	
	private final CityRepository cityRepository;
	private final CityMapper cityMapper;
	
	/**
	 * @param cityService
	 */
	public CityController(CityRepository cityRepository,CityMapper cityMapper) {	
		this.cityRepository = cityRepository;
		this.cityMapper= cityMapper;
	}

	@GetMapping("/cities")
	public Page<City> getList(Pageable pageable){		
		if(pageable == null){
			return this.cityRepository.findAll(pageable);
	    }else {
	    	int page;
	    	page = pageable.getPageNumber() -1;
	    	Pageable query_pageable = new PageRequest(page>0? page:0,pageable.getPageSize(),pageable.getSort());
			return this.cityRepository.findAll(query_pageable);
	    } 
	}
	
	@GetMapping("/province/{provinceId}/cities")
	public  Page<City> getListProvinceByProvinceId(@PathVariable("provinceId") Long provinceId, Pageable pageable) {
		if(pageable == null){
			return this.cityRepository.findByProvinceId(provinceId, pageable);
	    }else {
	    	int page = pageable.getPageNumber()==0? pageable.getPageNumber(): pageable.getPageNumber() -1;
	    	Pageable query_pageable = new PageRequest(page>0? page:0,pageable.getPageSize(),pageable.getSort());
			return this.cityRepository.findByProvinceId(provinceId, query_pageable);
	    } 		
	}
	
	@GetMapping("/city/{id}")
	public City find(@PathVariable("id") Long id) {
		return cityRepository.findOne(id);
	}
	
	@PostMapping("/city")
	public ResponseEntity<CityDto> create(@RequestBody CityDto cityDto) {				
		cityRepository.save(cityMapper.toEntity(cityDto));		
		return ResponseEntity.status(HttpStatus.CREATED).body(cityDto);
	}	
	
	@DeleteMapping("/city/{id}")
	public void delete(@PathVariable("id") Long id) {
		cityRepository.delete(id);
	}
	
	@PutMapping("/city")
	public ResponseEntity<CityDto> update(@RequestBody CityDto cityDto) throws BadHttpRequest  {			
		if (cityRepository.exists(cityDto.getId())) {
			//country.setId(id);
			cityRepository.save(cityMapper.toEntity(cityDto));		
			return ResponseEntity.status(HttpStatus.CREATED).body(cityDto);
		} else {
			throw new BadHttpRequest();
		}
	}	

}
