import { Injectable } from "@angular/core";
import { Customer } from "./customer";
import { Inventory } from "./inventory";
import { Product } from "./product";

@Injectable({
    providedIn: 'root',
  })

export class InventoryProductCustomerStore{
product!:Product
store!:Object
customer!:Customer

}