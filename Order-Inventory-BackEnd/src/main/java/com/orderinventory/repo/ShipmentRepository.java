package com.orderinventory.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.orderinventory.entities.Customer;
import com.orderinventory.entities.Shipment;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Integer>{
	
	
	@Query("select sp.shipmentId from Shipment sp")
	public List<Integer> findAllShipmentId();
	
	public List<Shipment> findByCustomer(Customer customer);
}
