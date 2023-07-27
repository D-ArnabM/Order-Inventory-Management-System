package com.orderinventory.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.orderinventory.dto.OrderInsight;
import com.orderinventory.dto.OrderStatusCount;
import com.orderinventory.dto.OrderStoreList;
import com.orderinventory.dto.ProdBrandCount;
import com.orderinventory.entities.Customer;
import com.orderinventory.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

	@Query("SELECT new com.orderinventory.dto.OrderStoreList(o.orderId, o.orderStatus, s.storeName, s.webAddress) " +
		       "FROM Order o JOIN o.store s " +
		       "WHERE s.storeId = :id")
	public List<OrderStoreList> findByStoreId(@Param("id") int id);
	
	@Query("SELECT  new com.orderinventory.dto.OrderStatusCount(o.orderStatus, COUNT(o.orderId)) " +
		       "FROM Order o " +
		       "WHERE o.orderStatus = :status " +
		       "GROUP BY o.orderStatus")
	public List<OrderStatusCount> getOrderCountByStatus(@Param("status") String orderStatus);
	
	public List<Order> findByCustomer(Customer customer);
	
	
	@Query("select new com.orderinventory.dto.OrderInsight(count(oi.order) as noOfOrders, sum(oi.quantity) as quantity, month(o.orderTimestamp) As month, sum(oi.unitPrice*oi.quantity) as totalSales) from Order o join OrderItem oi on o.orderId = oi.order.orderId where year(o.orderTimestamp)=:year group by month(o.orderTimestamp)")
	public List<OrderInsight> getOrderInsightByYear(@Param("year") int year);
	
	
	@Query("select new com.orderinventory.dto.OrderInsight(count(oi.order) as noOfOrders, sum(oi.quantity) as quantity, month(o.orderTimestamp) As month, sum(oi.unitPrice*oi.quantity) as totalSales) from Order o join OrderItem oi on o.orderId = oi.order.orderId where year(o.orderTimestamp)=:year and month(o.orderTimestamp)=:month group by month(o.orderTimestamp)")
	public List<OrderInsight> getOrderInsightByYearMonth(@Param("year") int year,@Param("month") int month);
	
	@Query("select new com.orderinventory.dto.ProdBrandCount(oi.product.productId as Id, count(oi.product) as count) from Order o join OrderItem oi on o.orderId = oi.order.orderId where year(o.orderTimestamp)=:year group by oi.product.productId")
	public List<ProdBrandCount> getProductBrandCountByYear(@Param("year") int year);
	
	@Query("select new com.orderinventory.dto.ProdBrandCount(oi.product.productId as Id, count(oi.product) as count) from Order o join OrderItem oi on o.orderId = oi.order.orderId where month(o.orderTimestamp)=:month and year(o.orderTimestamp)=:year group by oi.product.productId")
	public List<ProdBrandCount> getProductBrandCountByYearAndMonth(@Param("year") int year,@Param("month") int month);
}
