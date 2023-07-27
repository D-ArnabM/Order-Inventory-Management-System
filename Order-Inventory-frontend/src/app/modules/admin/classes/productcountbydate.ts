import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root',
})

export class ProductCountByDate {
    id !: number;
    count !: number;
}