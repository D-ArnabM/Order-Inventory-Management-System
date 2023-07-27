import { Injectable } from "@angular/core";
import { Customer } from "./customer";
import { Product } from "./product";
import { Store } from "./store";


@Injectable({
    providedIn: 'root',
  })

export class ProductCustomerStore{
    product : Product = new Product();
    customer : Customer = new Customer();
    store : Store = new Store();
}