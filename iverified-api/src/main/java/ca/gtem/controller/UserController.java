package ca.gtem.controller;

import java.util.Date;
import java.util.HashMap;

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
import ca.gtem.dto.UserDto;
import ca.gtem.mapper.UserMapper;
import ca.gtem.model.Country;
import ca.gtem.model.User;
import ca.gtem.repository.CountryRepository;
import ca.gtem.repository.UserRepository;
import javassist.tools.web.BadHttpRequest;

import ca.gtem.util.StringUtil;

@RestController
@RequestMapping("/api")
public class UserController {
	private final UserRepository userRepository;	
	private final UserMapper userMapper;
	
	/**
	 * @param cityService
	 */
	public UserController(UserRepository userRepository, UserMapper userMapper) {	
		this.userRepository = userRepository;		
		this.userMapper=userMapper;
	}

	@GetMapping("/users")
	public Page<User> getList(Pageable pageable){				
		if(pageable == null){
			return this.userRepository.findAll(pageable);
	    }else {
	    	int page;
	    	page = pageable.getPageNumber() -1;
	    	Pageable query_pageable = new PageRequest(page>0? page:0,pageable.getPageSize(),pageable.getSort());
			return this.userRepository.findAll(query_pageable);
	    } 		
	}
	
	@GetMapping("/user/{id}")
	public User find(@PathVariable("id") Long id) {
		return userRepository.findOne(id);
	}	
	
	
	@PostMapping("/user")
	public ResponseEntity<UserDto> create(@RequestBody UserDto userDto) {				
		userRepository.save(userMapper.toEntity(userDto));		
		return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody UserDto userDto) {				
		HashMap<String, String> responseObject = new HashMap<>();		
		User user =userRepository.findByUsername(userDto.getUsername());
		if (user.getPassword().equals(StringUtil.applySha256(userDto.getPassword()))) {
			responseObject.put("token", StringUtil.applySha256(userDto.getUsername()+ Long.toString(new Date().getTime())));
			responseObject.put("user", userDto.getUsername());			
		}
		else {
			responseObject.put("token", "");
			responseObject.put("err","Wrong");
		}
		responseObject.put("time", new Date().toString());
		return new ResponseEntity<Object>(responseObject, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/user/{id}")
	public void delete(@PathVariable("id") Long id) {
		userRepository.delete(id);
	}
	
	@PutMapping("/user")
	public ResponseEntity<UserDto> update(@RequestBody UserDto userDto) throws BadHttpRequest  {
		if (userRepository.exists(userDto.getId())) {			
			userRepository.save(userMapper.toEntity(userDto));		
			return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
		} else {
			throw new BadHttpRequest();
		}
	}
}
