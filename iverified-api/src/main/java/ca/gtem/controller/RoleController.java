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

import ca.gtem.model.Role;
import ca.gtem.repository.RoleRepository;
import javassist.tools.web.BadHttpRequest;

public class RoleController {
private final RoleRepository roleRepository;
	
	/**
	 * @param roleRepository
	 */
	public RoleController(RoleRepository roleRepository) {	
		this.roleRepository = roleRepository;
	}

	@GetMapping("/roles")
	public Page<Role> getList(Pageable pageable){				
		if(pageable == null){
			return this.roleRepository.findAll(pageable);
	    }else {
	    	int page;
	    	page = pageable.getPageNumber() -1;
	    	Pageable query_pageable = new PageRequest(page>0? page:0,pageable.getPageSize(),pageable.getSort());
			return this.roleRepository.findAll(query_pageable);
	    } 		
	}
	
	@GetMapping("/role/{id}")
	public Role find(@PathVariable("id") Long id) {
		return roleRepository.findOne(id);
	}
	
	@PostMapping("/role")
	public Role create(@RequestBody Role role) {		
		return roleRepository.save(role);		
	}
	
	@DeleteMapping("/role/{id}")
	public void delete(@PathVariable("id") Long id) {
		roleRepository.delete(id);
	}
	
	@PutMapping("/role")
	public Role update(@RequestBody Role role) throws BadHttpRequest  {
		if (roleRepository.exists(role.getId())) {
			//country.setId(id);
			return roleRepository.save(role);
		} else {
			throw new BadHttpRequest();
		}
	}

}
