import { Injectable } from "@angular/core";
import { Customer } from "./customer";
import { Order } from "./order";

@Injectable({
    providedIn: 'root',
  })

export class CustomerOrder{
    customer : Customer = new Customer();
    order : Order[] = [];
}