package com.crud.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.demo.entity.UserEntity;

@Repository
public interface CrudRepository extends JpaRepository< UserEntity, Long >{

}
