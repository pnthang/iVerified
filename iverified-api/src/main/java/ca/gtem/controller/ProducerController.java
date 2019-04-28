package ca.gtem.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

import ca.gtem.model.Producer;
import ca.gtem.repository.ProducerRepository;
import ca.gtem.util.ImageUtil;
import ca.gtem.dto.ProducerDto;
import ca.gtem.mapper.ProducerMapper;
import javassist.tools.web.BadHttpRequest;

import ca.gtem.util.ImageUtil;

@RestController
@RequestMapping("/api")
public class ProducerController {	
	private final ProducerRepository producerRepository;	
	private final ProducerMapper producerMapper;
	
	@Value("${file.root-dir}")
	private String rootDir;	
	
	@Value("${file.producer-dir}")
	private String producerDir;
	/**
	 * @param producerRepository
	 * @param producerMapper
	 */
	public ProducerController(ProducerRepository producerRepository, ProducerMapper producerMapper) {		
		this.producerRepository = producerRepository;
		this.producerMapper = producerMapper;
	}

	@GetMapping("/producers")
	public Page<Producer> getList(Pageable pageable){				
		if(pageable == null){
			return this.producerRepository.findAll(pageable);
	    }else {
	    	int page;
	    	page = pageable.getPageNumber() -1;
	    	Pageable query_pageable = new PageRequest(page>0? page:0,pageable.getPageSize(),pageable.getSort());
			return this.producerRepository.findAll(query_pageable);
	    } 		
	}

	
	@GetMapping("/producer/{id}")
	public Producer find(@PathVariable("id") Long id) {
		return producerRepository.findOne(id);
	}
	
	@PostMapping("/producer")	
	public ResponseEntity<ProducerDto> create(@RequestBody ProducerDto producerDto) {				
		producerRepository.save(producerMapper.toEntity(producerDto));		
		return ResponseEntity.status(HttpStatus.CREATED).body(producerDto);
	}
	
	@DeleteMapping("/producer/{id}")
	public void delete(@PathVariable("id") Long id) {
		Producer producer = producerRepository.findOne(id);
		ImageUtil.deleteImage(producer.getLogoImage(), rootDir + producerDir);
		producerRepository.delete(id);
	}
	
	@PutMapping("/producer")
	public ResponseEntity<ProducerDto> update(@RequestBody ProducerDto producerDto) throws BadHttpRequest  {
		if (producerRepository.exists(producerDto.getId())) {
			//producer.setId(id);
			producerRepository.save(producerMapper.toEntity(producerDto));		
			return ResponseEntity.status(HttpStatus.CREATED).body(producerDto);		
		} else {
			throw new BadHttpRequest();
		}
	}
}
