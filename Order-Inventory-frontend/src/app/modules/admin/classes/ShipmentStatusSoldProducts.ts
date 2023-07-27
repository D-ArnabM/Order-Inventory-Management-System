import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root',
  })

export class ShipmentStatusSoldProducts{
    shipmentStatus!:String
    soldProducts!:number
    
}