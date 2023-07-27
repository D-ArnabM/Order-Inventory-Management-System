package com.orderinventory.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderinventory.dto.OrderInsight;
import com.orderinventory.dto.OrderStatusCount;
import com.orderinventory.dto.OrderStoreList;
import com.orderinventory.dto.ProdBrandCount;
import com.orderinventory.entities.Order;
import com.orderinventory.entities.OrderItem;
import com.orderinventory.entities.Shipment;
import com.orderinventory.repo.OrderItemRepository;
import com.orderinventory.repo.OrderRepository;
import com.orderinventory.repo.ShipmentRepository;

@Service
public class OrderServices implements OrderServiceInterface{
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private ShipmentRepository shipmentRepository;
	
	public List<Order> getAllOrders(){
		return orderRepository.findAll();
	}
	
	public Order addOrder(Order order) {
		return orderRepository.save(order);
	}
	
	public Order updateOrder(Order order) {
		Order updatedOrder = orderRepository.findById(order.getOrderId()).orElse(null);
		updatedOrder.setOrderStatus(order.getOrderStatus());
		updatedOrder.setCustomer(order.getCustomer());
		updatedOrder.setOrderTimestamp(order.getOrderTimestamp());
		updatedOrder.setStore(order.getStore());		
		
		return orderRepository.save(updatedOrder);
	}
	
	public String deleteOrderById(int id) {
		Order order = orderRepository.findById(id).orElse(null);
		if (order!=null) {
			
			List<OrderItem> orderItems = orderItemRepository.findByOrder(order);
			if(orderItems != null) {
			
				for(OrderItem orderItem : orderItems) {
					shipmentRepository.delete(orderItem.getShipmentId());
				}
			
			orderItemRepository.deleteAll(orderItems);}
			orderRepository.deleteById(id);
			return "Record deleted Successfully";
		}
		return "failed";
	}
	
	public List<OrderStatusCount> getOrderCountByStatus(String orderStatus){
		return orderRepository.getOrderCountByStatus(orderStatus);
	}
	
	public List<OrderStoreList> getOrdersByStoreId(int id){
		return orderRepository.findByStoreId(id);
	}
	
	public List<OrderInsight> getAllOrderInsightByYear(int year){
		return orderRepository.getOrderInsightByYear(year);
	}
	
	public List<OrderInsight> getAllOrderInsightByYearMonth(int year, int month){
		return orderRepository.getOrderInsightByYearMonth(year, month);
	}
	
	public List<ProdBrandCount> getProductBrandCount(int year){
		return orderRepository.getProductBrandCountByYear(year);
	}
	
	public List<ProdBrandCount> getProductBrandCountByYandM(int year,int month){
		return orderRepository.getProductBrandCountByYearAndMonth(year, month);
	}
}
