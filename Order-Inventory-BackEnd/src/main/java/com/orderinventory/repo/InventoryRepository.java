package com.orderinventory.repo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.orderinventory.dto.InventoryProductCustomerStore;
import com.orderinventory.dto.InventoryProductOrderStatus;
import com.orderinventory.dto.InventoryProductStoreShipmentStatusSum;
import com.orderinventory.dto.InventoryShipment;
import com.orderinventory.dto.ShipmentStatusSoldProducts;
import com.orderinventory.entities.Inventory;


@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer>{
	
	@Query("select new com.orderinventory.dto.InventoryProductCustomerStore(oi.product, o.customer, o.store) "
			+"from Order o join OrderItem oi "
			+"on o.orderId = oi.order.orderId "
			+"where o.orderId =:id")
	public InventoryProductCustomerStore findProductCustomerStoreByOrderId(@Param("id") int orderId);
	
	@Query("SELECT new com.orderinventory.dto.InventoryProductStoreShipmentStatusSum(oi.product, o.store, oi.shipment.shipmentStatus, SUM(oi.unitPrice * oi.quantity) AS total) " +
	        "FROM OrderItem oi " +
	        "JOIN oi.order o " +
	        "WHERE oi.order.orderId = :orderId " +
	        "GROUP BY oi.product")
	public List<InventoryProductStoreShipmentStatusSum> findInventoryDetailsByOrderId(@Param("orderId") int orderId);

	@Query("SELECT new com.orderinventory.dto.InventoryProductOrderStatus(oi.product, o.orderStatus as orderStatus) " +
	        "FROM OrderItem oi " +
	        "JOIN oi.order o " +
	        "WHERE o.store.storeId = :storeId")
	public List<InventoryProductOrderStatus> findProductOrderStatusByStoreId(@Param("storeId") int storeId);
	
	@Query("SELECT new com.orderinventory.dto.InventoryShipment(sp, i) FROM Shipment sp JOIN Inventory i on sp.store.storeId = i.store.storeId WHERE sp.shipmentId = :shipmentId")
	public InventoryShipment findInventoryShipmentById(@Param("shipmentId") int shipmentId);
	
	@Query("select new com.orderinventory.dto.ShipmentStatusSoldProducts('DELIVERED' as status, count(o.product)) from Shipment s join OrderItem o on s.shipmentId = o.shipment.shipmentId where s.shipmentStatus = 'DELIVERED'")
	public ShipmentStatusSoldProducts findSoldProductsByShipmentStatus();
}
