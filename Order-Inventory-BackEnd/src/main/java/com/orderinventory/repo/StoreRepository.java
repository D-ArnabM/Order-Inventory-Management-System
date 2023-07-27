package com.orderinventory.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orderinventory.entities.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer>{

}
