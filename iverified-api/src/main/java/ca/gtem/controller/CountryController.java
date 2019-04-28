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

import ca.gtem.model.Country;
import ca.gtem.repository.CountryRepository;
import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping("/api")
public class CountryController {
	private final CountryRepository countryRepository;	
	
	/**
	 * @param cityService
	 */
	public CountryController(CountryRepository countryRepository) {	
		this.countryRepository = countryRepository;		
	}

	@GetMapping("/countries")
	public Page<Country> getList(Pageable pageable){				
		if(pageable == null){
			return this.countryRepository.findAll(pageable);
	    }else {
	    	int page;
	    	page = pageable.getPageNumber() -1;
	    	Pageable query_pageable = new PageRequest(page>0? page:0,pageable.getPageSize(),pageable.getSort());
			return this.countryRepository.findAll(query_pageable);
	    } 		
	}
	
	@GetMapping("/country/{id}")
	public Country find(@PathVariable("id") Long id) {
		return countryRepository.findOne(id);
	}		
	
	@PostMapping("/country")
	public Country create(@RequestBody Country country) {		
		return countryRepository.save(country);		
	}
	
	@DeleteMapping("/country/{id}")
	public void delete(@PathVariable("id") Long id) {
		countryRepository.delete(id);
	}
	
	@PutMapping("/country")
	public Country update(@RequestBody Country country) throws BadHttpRequest  {
		if (countryRepository.exists(country.getId())) {
			//country.setId(id);
			return countryRepository.save(country);
		} else {
			throw new BadHttpRequest();
		}
	}

}
