package com.crud.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.crud.demo.dto.UserDto;
import com.crud.demo.entity.UserEntity;
import com.crud.demo.exception.UserAlreadyExistsException;
import com.crud.demo.exception.UserNotFoundException;
import com.crud.demo.repository.CrudRepository;

@Service
public class CrudService {

	@Autowired
	private CrudRepository repository;


	public UserDto save(UserDto dto) {
	    UserEntity entity = mapToEntity(dto);
	    entity.setId(null);

	    try {
	        UserEntity saved = repository.save(entity);
	        return mapToDto(saved);
	    } catch (DataIntegrityViolationException ex) {
	        throw new UserAlreadyExistsException(dto.getEmail());
	    }
	}

	public List<UserDto> findAll() {
		return repository.findAll().stream()
								.map(this::mapToDto)
								.collect(Collectors.toList()
			);
	}
	

	public UserDto findById(Long id) {
	    return repository.findById(id)
	                     .map(this::mapToDto)
	                     .orElseThrow(() -> new UserNotFoundException(id));
	}


	public boolean existsById(Long id) {
		return repository.existsById(id);
	}
	

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	

	public UserDto update(Long id, UserDto dto) {
	    return repository.findById(id)
	            .map(existing -> {
	                existing.setName(dto.getName());
	                existing.setEmail(dto.getEmail());
	                try {
	                    UserEntity updated = repository.save(existing);
	                    return mapToDto(updated);
	                } catch (DataIntegrityViolationException ex) {
	                    throw new UserAlreadyExistsException(dto.getEmail());
	                }
	            })
	            .orElseThrow(() -> new UserNotFoundException(id));
	}
	
	
	private UserDto mapToDto(UserEntity user) {
		UserDto dto = new UserDto();
		dto.setId(user.getId());
		dto.setName(user.getName());
		dto.setEmail(user.getEmail());
		return dto;
	}

	
	private UserEntity mapToEntity(UserDto dto) {
		UserEntity user = new UserEntity();
		user.setId(dto.getId());
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		return user;
	}

}
