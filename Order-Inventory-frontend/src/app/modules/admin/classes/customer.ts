import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root',
  })

export class Customer{
    customerId !: number;
    emailAddress !: string; 
    fullName !: string;
}