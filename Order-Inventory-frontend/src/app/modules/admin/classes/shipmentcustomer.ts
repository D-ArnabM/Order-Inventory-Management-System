import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root',
  })

export class ShipmentCustomer{
    shipmentStatus !: string;
    count !: number;
}