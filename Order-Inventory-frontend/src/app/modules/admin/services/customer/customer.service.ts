import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../../classes/customer';
import { CustomerOrder } from '../../classes/customerorder';
import { CustomerShipments } from '../../classes/customershipments';
import { ShipmentCustomer } from '../../classes/shipmentcustomer';


@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient) { }

  // Base Url
  private baseUrl = "http://localhost:8005/api/v1/customers"

  // Getting All the Customers
  getAllCustomers() : Observable<Customer[]>{
    return this.http.get<Customer[]>(this.baseUrl);
  }

  //Adding Customer
  addCustomer(customer : Customer) : Observable<string>{
    return this.http.post<string>(this.baseUrl, customer)
  }

  //Updating Customer
  updateCustomer(customer : Customer) : Observable<string>{
    return this.http.put<string>(this.baseUrl,customer);
  }

  //Deleting Customer
  deleteCustomer(customer : Customer){
    return this.http.delete(this.baseUrl+`/${customer.customerId}`);
  }

  //Search Customers Matching emailid
  getCustomersByEmail(emailId : string) : Observable<Customer[]>{
    return this.http.get<Customer[]>(this.baseUrl+`/`+emailId);
  }

  //Search Customers Matching name wildcard
  getCustomersByName(firstName : string) : Observable<Customer[]>{
    return this.http.get<Customer[]>(this.baseUrl+`?name=`+firstName);
  }

  // Get Custom Object of Shipment Status and count of customers
  getShipmentStatusWiseCustomerCount() : Observable<ShipmentCustomer[]>{
    return this.http.get<ShipmentCustomer[]>(this.baseUrl+`/shipment/status`);
  }

  getCustomerOrders(customerId:number):Observable<CustomerOrder>{
    return this.http.get<CustomerOrder>(this.baseUrl+`/${customerId}`+`/order`);
  }
  
  //Fetch orders for the respective customer by id
  getOrdersByCustomerId(customerId : number) : Observable<CustomerOrder>{
    return this.http.get<CustomerOrder>(this.baseUrl+`/${customerId}/order`);
  }

  //Fetch Shipments matching Id
  getShipmentsByCustomerId(customerId : number) : Observable<CustomerShipments>{
    return this.http.get<CustomerShipments>(this.baseUrl+`/${customerId}/shipment`)
  }
}
