package com.orderinventory.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderinventory.entities.Store;
import com.orderinventory.repo.StoreRepository;


@Service
public class StoreServices implements StoreServiceInterface{
	
	@Autowired
	private StoreRepository repo;
	
	
	public List<Store> getAllStores(){
		return repo.findAll();
	}
	
	public String getWebAddressByStoreId(int storeId){
		
		String webAddress = repo.findById(storeId).get().getWebAddress();
		return webAddress;
	}
}
