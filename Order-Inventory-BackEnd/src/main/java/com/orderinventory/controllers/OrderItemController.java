package com.orderinventory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderinventory.entities.OrderItem;
import com.orderinventory.exceptions.NotFoundException;
import com.orderinventory.services.OrderItemServices;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/orderitems")
public class OrderItemController {
	
	@Autowired
	private OrderItemServices orderItem;
	
	
	@GetMapping
	public ResponseEntity<List<OrderItem>> getAllOrderItem(){
		if(orderItem==null) {
			throw new NotFoundException("order item not found");
		}
		return new ResponseEntity<List<OrderItem>> (orderItem.getAllOrderItem(),HttpStatus.OK);
	}
}
