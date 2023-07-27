import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root',
})

export class Product {
    productId !: number;
    productName !: string; 
    unitPrice !: number; 
    colour !: string; 
    brand !: string; 
    size !: string;
	rating !: number;
}