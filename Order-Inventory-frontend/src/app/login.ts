import { Injectable } from "@angular/core";

@Injectable({
  providedIn: 'root',
})

export class Login{
    email !:string;
    password !:string;
  }