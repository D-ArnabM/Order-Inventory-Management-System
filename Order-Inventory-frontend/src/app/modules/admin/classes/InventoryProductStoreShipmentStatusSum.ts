import { Injectable } from "@angular/core";
import { Inventory } from "./inventory";
import { Product } from "./product";
import { Store } from "./store";

@Injectable({
    providedIn: 'root',
  })

export class InventoryProductStoreShipmentStatusSum{
product!:Product
  // productId!: number;
store!:Store
shipmentStatus!:string
total!:number

}