import { Injectable } from "@angular/core";
import { Customer } from "./customer";
import { Store } from "./store";


@Injectable({
    providedIn: 'root',
  })

  export class Order{

    orderId!:number;
    orderStatus!:string;
    customer :Customer = new Customer();
    orderTimestamp!:Date;
    store:Store = new Store();
  }

 