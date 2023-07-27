package com.orderinventory.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orderinventory.entities.Order;
import com.orderinventory.entities.OrderItem;
import com.orderinventory.entities.Shipment;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer>{

		public List<OrderItem> findByShipment(Shipment shipment);
		
		public List<OrderItem> findByOrder(Order order);
}
