import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { Inventory } from '../../classes/inventory';
import { InventoryProductStoreShipmentStatusSum } from '../../classes/InventoryProductStoreShipmentStatusSum';
import { InventoryShipment } from '../../classes/InventoryShipment';
import { InventoryStoreProductOrderStatus } from '../../classes/InventoryStoreProductOrderStatus';
import { ProductCustomerStore } from '../../classes/ProductCustomerStore';
import { ShipmentStatusSoldProducts } from '../../classes/ShipmentStatusSoldProducts';


@Injectable({
  providedIn: 'root'
})
export class InventoryService {


  constructor(private http:HttpClient) { }
private baseUrl="http://localhost:8005/api/v1/inventory"
 
getAllInventory():Observable<Inventory[]>{
  return this.http.get<Inventory[]>(this.baseUrl);
}

getProductCustomerStoreByOrderId(orderId: number): Observable<ProductCustomerStore> {
  const url = `${this.baseUrl}/${orderId}`;
  return this.http.get<ProductCustomerStore>(this.baseUrl+`/orderid/${orderId}`);
}
getInventoryDetailsByOrderId(orderId: number): Observable<InventoryProductStoreShipmentStatusSum[]> {
  const url = `${this.baseUrl}/${orderId}/details`;
  return this.http.get<InventoryProductStoreShipmentStatusSum[]>(url);
}
getProductOrderStatusByStoreId(storeId: number): Observable<InventoryStoreProductOrderStatus[]> {
 return this.http.get<InventoryStoreProductOrderStatus[]>(this.baseUrl+`/store?storeid=`+storeId);
}
getInventoryShipmentById(shipmentId:number):Observable<InventoryShipment[]>{
  const url = `${this.baseUrl}/shipmentid`
 return this.http.get<InventoryShipment[]>(url)
}
getCountOfSoldProductsByShipmentStatus():Observable<ShipmentStatusSoldProducts>{
  const url=`${this.baseUrl}/shipment/soldproducts`;
  return this.http.get<ShipmentStatusSoldProducts>(url)
}
}

















