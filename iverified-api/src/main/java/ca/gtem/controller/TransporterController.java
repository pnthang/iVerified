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

import ca.gtem.dto.TransporterDto;
import ca.gtem.mapper.TransporterMapper;
import ca.gtem.model.Transporter;
import ca.gtem.repository.TransporterRepository;
import ca.gtem.util.ImageUtil;
import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping("/api")
public class TransporterController {
	private final TransporterRepository transporterRepository;	
	private final TransporterMapper transporterMapper;

	@Value("${file.root-dir}")
	private String rootDir;	
	
	@Value("${file.transporter-dir}")
	private String transporterDir;
	
	/**
	 * @param transporterRepository
	 * @param producerMapper
	 */
	public TransporterController(TransporterRepository transporterRepository, TransporterMapper transporterMapper) {		
		this.transporterRepository = transporterRepository;
		this.transporterMapper = transporterMapper;
	}

	@GetMapping("/transporters")
	public Page<Transporter> getList(Pageable pageable){				
		if(pageable == null){
			return this.transporterRepository.findAll(pageable);
	    }else {
	    	int page;
	    	page = pageable.getPageNumber() -1;
	    	Pageable query_pageable = new PageRequest(page>0? page:0,pageable.getPageSize(),pageable.getSort());
			return this.transporterRepository.findAll(query_pageable);
	    } 		
	}

	
	@GetMapping("/transporter/{id}")
	public Transporter find(@PathVariable("id") Long id) {
		return transporterRepository.findOne(id);
	}
	
	@PostMapping("/transporter")	
	public ResponseEntity<TransporterDto> create(@RequestBody TransporterDto transporterDto) {				
		transporterRepository.save(transporterMapper.toEntity(transporterDto));		
		return ResponseEntity.status(HttpStatus.CREATED).body(transporterDto);
	}
	
	@DeleteMapping("/transporter/{id}")
	public void delete(@PathVariable("id") Long id) {
		Transporter transporter = transporterRepository.findOne(id);
		ImageUtil.deleteImage(transporter.getLogoImage(), rootDir + transporterDir);
		transporterRepository.delete(id);
	}
	
	@PutMapping("/transporter")
	public ResponseEntity<TransporterDto> update(@RequestBody TransporterDto transporterDto) throws BadHttpRequest  {
		if (transporterRepository.exists(transporterDto.getId())) {
			//producer.setId(id);
			transporterRepository.save(transporterMapper.toEntity(transporterDto));		
			return ResponseEntity.status(HttpStatus.CREATED).body(transporterDto);
		} else {
			throw new BadHttpRequest();
		}
	}
}
