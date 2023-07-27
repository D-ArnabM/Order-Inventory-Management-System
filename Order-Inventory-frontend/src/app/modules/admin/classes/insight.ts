import { Injectable } from "@angular/core";


@Injectable({
    providedIn: 'root',
  })

export class Insight{
    noOfOrders !: number;
    quantity !: number;
    month !:number;
    totalSales !:number;
}