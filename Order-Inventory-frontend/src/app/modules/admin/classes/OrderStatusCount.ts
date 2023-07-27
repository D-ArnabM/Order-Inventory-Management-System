import { Injectable } from "@angular/core";




@Injectable({
    providedIn: 'root',
  })

  export class OrderStatusCount{
    orderStatus!:string;
    count!:number;
  }
