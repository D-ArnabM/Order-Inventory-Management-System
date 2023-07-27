import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Insight } from '../../classes/insight';

import { OrderStatusCount } from '../../classes/OrderStatusCount';
import { OrderStoreList } from '../../classes/OrderStoreList';
import { ProductCountByDate } from '../../classes/productcountbydate';
import { Order } from '../../classes/order';


@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http:HttpClient) { }

private baseUrl="http://localhost:8005/api/v1/orders"


getAllOrders():Observable<Order[]>{
  return this.http.get<Order[]>(this.baseUrl)
}

addOrder(order:Order):Observable<string>{
  return this.http.post<string>(this.baseUrl,order);
}


updateOrder(order:Order):Observable<string>{
  return this.http.put<string>(this.baseUrl,order);
}

deleteOrder(order:Order){
  return this.http.delete(this.baseUrl+`/${order.orderId}`);
  

}

getOrderCountByStatus(orderStatus:string):Observable<OrderStatusCount[]>{
  return this.http.get<OrderStatusCount[]>(this.baseUrl+`/status?orderstatus=`+`${orderStatus}`);
}

getOrderListByStoreId(storeId:number):Observable<OrderStoreList[]>{
  return this.http.get<OrderStoreList[]>(this.baseUrl+`/store?storeid=`+storeId);
}

getAllOrderInsightByYear(year : number):Observable<Insight[]>{
  return this.http.get<Insight[]>(this.baseUrl+`/insight?year=${year}`);
}

getAllOrderInsightByYearorMonth(year : number, month : number) : Observable<Insight[]>{
  return this.http.get<Insight[]>(this.baseUrl+`/insight?year=${year}&month=${month}`);
}


getAllProductCountByYear(year : number):Observable<ProductCountByDate[]>{
  return this.http.get<ProductCountByDate[]>(this.baseUrl+`/productcount?year=${year}`);
}

getAllProductCount(year : number, month : number) : Observable<ProductCountByDate[]>{
  return this.http.get<ProductCountByDate[]>(this.baseUrl+`/productcount?year=${year}&month=${month}`);
}
}
