package com.orderinventory.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orderinventory.entities.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer>{
	
//	public Login findByEmailAddress(String emailAddress);
	
	public Optional<Login> findByEmailAddress(String emailAddress);
}
