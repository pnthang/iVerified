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

import ca.gtem.dto.BlockDto;
import ca.gtem.mapper.BlockMapper;
import ca.gtem.model.Block;
import ca.gtem.repository.BlockRepository;
import ca.gtem.util.ImageUtil;
import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping(path = "/api")
public class BlockController {
	
	private final BlockRepository blockRepository;
	
	private final BlockMapper blockMapper;
	
	@Value("${file.root-dir}")
	private String rootDir;	
	
	@Value("${file.transfer-dir}")
	private String transferDir;
	/**
	 * @param blockRepository
	 * @param blockMapper
	 */
	public BlockController(BlockRepository blockRepository, BlockMapper blockMapper) {
		super();
		this.blockRepository = blockRepository;
		this.blockMapper = blockMapper;
	}
	
	@GetMapping("/blocks")
	public Page<Block> getList(Pageable pageable){		
		if(pageable == null){
			return this.blockRepository.findAll(pageable);
	    }else {
	    	int page;
	    	page = pageable.getPageNumber() -1;
	    	Pageable query_pageable = new PageRequest(page>0? page:0,pageable.getPageSize(),pageable.getSort());
			return this.blockRepository.findAll(query_pageable);
	    } 
	}
	
	@GetMapping("/product/{productId}/blocks")
	public  Page<Block> getListByProductId(@PathVariable("productId") Long productId, Pageable pageable) {
		if(pageable == null){
			return this.blockRepository.findByProductId(productId, pageable);
	    }else {
	    	int page = pageable.getPageNumber()==0? pageable.getPageNumber(): pageable.getPageNumber() -1;
	    	Pageable query_pageable = new PageRequest(page>0? page:0,pageable.getPageSize(),pageable.getSort());
			return this.blockRepository.findByProductId(productId, query_pageable);
	    } 		
	}
	
	@GetMapping("/block/{id}")
	public Block find(@PathVariable("id") Long id) {
		return blockRepository.findOne(id);
	}
	
	@PostMapping("/block")
	public ResponseEntity<BlockDto> create(@RequestBody BlockDto blockDto) {				
		blockRepository.save(blockMapper.toEntity(blockDto));		
		return ResponseEntity.status(HttpStatus.CREATED).body(blockDto);
	}	
	
	@DeleteMapping("/block/{id}")
	public void delete(@PathVariable("id") Long id) {
		Block block = blockRepository.findOne(id);
		ImageUtil.deleteImage(block.getImage(), rootDir + transferDir);
		blockRepository.delete(id);
	}
	
	@PutMapping("/block")
	public ResponseEntity<BlockDto> update(@RequestBody BlockDto blockDto) throws BadHttpRequest  {			
		if (blockRepository.exists(blockDto.getId())) {
			//country.setId(id);
			blockRepository.save(blockMapper.toEntity(blockDto));		
			return ResponseEntity.status(HttpStatus.CREATED).body(blockDto);
		} else {
			throw new BadHttpRequest();
		}
	}

}
