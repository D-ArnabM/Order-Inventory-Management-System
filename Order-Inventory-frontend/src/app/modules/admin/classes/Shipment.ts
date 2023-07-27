import { Injectable } from "@angular/core";
import { Customer } from "./customer";
import { Store } from "./store";

@Injectable({
    providedIn: 'root',
  })

export class shipment{
    shipmentId!: number;
    store:Store = new Store();
    customer:Customer = new Customer();
    deliveryAddress!:string
    shipmentStatus!:string



}