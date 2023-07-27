import { Injectable } from "@angular/core";
import { Customer } from "./customer";
import { shipment } from "./Shipment";

@Injectable({
    providedIn: 'root',
  })

export class CustomerShipments{
    customer : Customer = new Customer();
    shipment : shipment[] = [];
}