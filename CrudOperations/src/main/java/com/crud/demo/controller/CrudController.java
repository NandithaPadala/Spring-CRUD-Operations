package com.crud.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.crud.demo.dto.UserDto;
import com.crud.demo.service.CrudService;

@RestController
@RequestMapping("/users")
public class CrudController {

	@Autowired
	private CrudService service;


	@GetMapping
	public ResponseEntity<List<UserDto>> getAllUsers() {
		List<UserDto> users = service.findAll();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto dto) {
	    UserDto saved = service.save(dto);
	    return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
	    UserDto user = service.findById(id); // throws UserNotFoundException automatically if not found
	    return ResponseEntity.ok(user);
	}

	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto dto) {
	    UserDto updated = service.update(id, dto); // throws exceptions automatically
	    return ResponseEntity.ok(updated);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
	    service.findById(id); // throws UserNotFoundException if not exists
	    service.deleteById(id);
	    return ResponseEntity.noContent().build();
	}


}