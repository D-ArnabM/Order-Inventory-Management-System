import { Injectable } from "@angular/core";
import { Product } from "./product";
import { Store } from "./store";


@Injectable({
    providedIn: 'root'
  })

export class InventoryStoreProductOrderStatus{
    product : Product = new Product();
    orderStatus !: string;

}