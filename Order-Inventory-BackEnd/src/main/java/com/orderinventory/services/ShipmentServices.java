package com.orderinventory.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderinventory.entities.Shipment;
import com.orderinventory.repo.ShipmentRepository;

@Service
public class ShipmentServices implements ShipmentServiceInterface{
	
	@Autowired
	private ShipmentRepository repo;
	
	public List<Shipment> getAllShipment(){
		return repo.findAll();
	}
}
