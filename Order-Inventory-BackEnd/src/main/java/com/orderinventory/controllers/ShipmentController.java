package com.orderinventory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderinventory.entities.Shipment;
import com.orderinventory.exceptions.InvaliddataException;
import com.orderinventory.services.ShipmentServices;

@RestController
@RequestMapping("/api/v1/shipments")
public class ShipmentController {
	
	@Autowired
	private ShipmentServices shipment;
	
	@GetMapping
	public ResponseEntity<List<Shipment>> getAllShipments(){
		List<Shipment> s=shipment.getAllShipment();
		if(shipment==null) {
			throw new InvaliddataException("No shipment is found with this name:"+shipment);
		}
		return new ResponseEntity<List<Shipment>>(s,HttpStatus.OK);
	}
}
