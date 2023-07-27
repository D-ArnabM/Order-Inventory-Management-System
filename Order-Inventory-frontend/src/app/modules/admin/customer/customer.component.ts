import { Component, OnInit } from '@angular/core';
import { Customer } from '../classes/customer';
import { ShipmentCustomer } from '../classes/shipmentcustomer';
import { CustomerService } from '../services/customer/customer.service';

import lottie from 'lottie-web';
import { defineElement } from 'lord-icon-element';
import { CustomerOrder } from '../classes/customerorder';
import { CustomerShipments } from '../classes/customershipments';



@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit{

  constructor(private service : CustomerService){}

  customers !: Customer[];
  shipmentStatusCustomerCount !: ShipmentCustomer[];
  customer : Customer = new Customer();
  customerOrders : CustomerOrder = new CustomerOrder();
  customerShipments : CustomerShipments = new CustomerShipments();
  bind : boolean = false;
  filterForEmail : boolean = false;
  filterForName : boolean = false;
  enableShipmentStatusCustomerCount : boolean = false;
  check !: string;

  customerOrderCheck : boolean = false;
  customerShipmentCheck : boolean = false;

  fullName !: string;
  customerId !: number;
  emailAddress !: string;

  ngOnInit(): void {
    this.getAllCusts();
  }

  onSubmit(){
    
  }

 isFormValid():boolean{
  return(
     !!this.customer.customerId&&
     !!this.customer.emailAddress&&
     !!this.customer.fullName
     );
  
 }



  getAllCusts(){
    this.customerOrderCheck = false;
    this.enableShipmentStatusCustomerCount = false;
    this.service.getAllCustomers().subscribe(data=>{
      this.customers = data;
    })
  }

  getCustomerToUpdate(cust : Customer){
    this.customer.customerId = cust.customerId;
    this.customer.fullName = cust.fullName;
    this.customer.emailAddress = cust.emailAddress;
    this.bind = true;
  }
  goBackToAdd(){
    this.bind = false;
    this.filterForEmail = false;
    this.filterForName = false;
    this.enableShipmentStatusCustomerCount = false;
    this.customerOrderCheck = false;
    this.customerShipmentCheck = false;
    this.customer = new Customer();
  }
  addCustomer(){
    this.service.addCustomer(this.customer).subscribe(data=>{
      console.log(data);
    },
    (err) => {
      this.getAllCusts();
      alert("Record Created Successfully")
    }
    )
  }

  updateCustomer(){
    this.service.updateCustomer(this.customer).subscribe(data=>{
      console.log(data);
    },
    (err) => {
      this.getAllCusts();
      alert("Customer is Updated!");
    });
  }


  setUpGetUsersByEmailAddress(){ 
    this.filterForEmail = true;
    this.filterForName = false;
  }

  getCustomersByEmailAddress(){
    this.service.getCustomersByEmail(this.customer.emailAddress).subscribe(customers => {
      this.customers = customers;
    });
  }

  setUpGetUsersByFirstName(){ 
    this.filterForName = true;
    this.filterForEmail = false;
  }

  

  getCustomersByFirstName(){
    this.service.getCustomersByName(this.customer.fullName).subscribe(customers =>{
      this.customers = customers;
    });
  }
  

  getShipmentStatusCustomerCount(){
    this.enableShipmentStatusCustomerCount = true;
    this.service.getShipmentStatusWiseCustomerCount().subscribe(counts=>{
    this.shipmentStatusCustomerCount = counts;
    })
  }


  getCustomerOrders(customerId : number){
    this.customerOrderCheck = true;
    this.service.getOrdersByCustomerId(customerId).subscribe(data =>{
      this.customerOrders = data;
      this.fullName = this.customerOrders.customer.fullName;
      this.customerId = this.customerOrders.customer.customerId;
      this.emailAddress = this.customerOrders.customer.emailAddress;
    })
  }

  getShipments(customerId : number){
    this.customerShipmentCheck = true;
    this.service.getShipmentsByCustomerId(customerId).subscribe(data=>{
      this.customerShipments = data;
      this.fullName = this.customerShipments.customer.fullName;
      this.customerId = this.customerShipments.customer.customerId;
      this.emailAddress = this.customerShipments.customer.emailAddress;
    })
  }
  

  validateEmail(email: string): boolean {
    const pattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  
    return pattern.test(email);
  }
}
