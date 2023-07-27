package com.orderinventory.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderinventory.entities.OrderItem;
import com.orderinventory.repo.OrderItemRepository;

@Service
public class OrderItemServices implements OrderItemServiceInterface {

	@Autowired
	private OrderItemRepository repo;
	
	
	public List<OrderItem> getAllOrderItem(){
		return repo.findAll();
	}
}
