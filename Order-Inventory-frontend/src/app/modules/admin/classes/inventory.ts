import { Injectable } from "@angular/core";
import { Product } from "./product";
import { Store } from "./store";

@Injectable({
    providedIn: 'root',
  })

export class Inventory {
    inventoryId!: number;
    store:Store=new Store();
    product:Product=new Product();
    
    
    productInventory!:number
}
