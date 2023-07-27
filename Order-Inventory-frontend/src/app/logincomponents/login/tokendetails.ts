import { Injectable } from "@angular/core";

@Injectable({
  providedIn: 'root',
})

export class TokenDetails{
    jwtToken !: string;
    username !: string
}