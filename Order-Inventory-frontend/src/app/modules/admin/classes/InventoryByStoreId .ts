import { Injectable } from "@angular/core";

import { Product } from "./product";

@Injectable({
    providedIn: 'root',
  })

export class InventoryByStoreId{
product!:Product
store!:Object
orderStatus!:string

}