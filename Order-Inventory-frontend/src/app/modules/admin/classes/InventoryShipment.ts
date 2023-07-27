import { Injectable } from "@angular/core";
import { Inventory } from "./inventory";
import {shipment}  from "./Shipment";
@Injectable({
    providedIn: 'root',
  })

export class InventoryShipment{
shipment!:shipment
inventory!:Inventory

}