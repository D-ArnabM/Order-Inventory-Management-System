import { Injectable } from "@angular/core";


@Injectable({
    providedIn: 'root',
  })

export class Store{
    storeId !: number; 
    storeName !: string; 
    webAddress !: string;
    physicalAddress !: string; 
    latitude !: number;
	longitude !: number;
    logoMimeType !: string;
    logoFilename !: string;
    logoCharset !: string;
	logoLastUpdated !: Date;
}