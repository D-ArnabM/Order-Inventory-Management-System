import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../../classes/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) { }

  //Base Url
  private baseUrl = "http://localhost:8005/api/v1/products"

    // Getting All the Products
  getAllProducts() : Observable<Product[]>{
    return this.http.get<Product[]>(this.baseUrl);
  }

  //Adding Product
  addProduct(product : Product) : Observable<string>{
    return this.http.post<string>(this.baseUrl, product);
  }

  //Updating Product
  updateProduct(customer : Product) : Observable<string>{
    return this.http.put<string>(this.baseUrl, customer);
  }

  //Deleting Product
  deleteProduct(product : Product){
    return this.http.delete(this.baseUrl+`/${product.productId}`);
  }

  //Search Products Matching product name
  getProductsByName(productName : string) : Observable<Product[]>{
    return this.http.get<Product[]>(this.baseUrl+`/`+productName);
  }

  //Fetch List of Products matching between min and max unit price
  getProductByMinMax(min : number, max : number) : Observable<Product[]>{
    return this.http.get<Product[]>(this.baseUrl+`/unitprice?min=${min}&max=${max}`);
  }

  //Get list of products order by query field
  getSortedProductsByField(field : string) : Observable<Product[]>{
    return this.http.get<Product[]>(this.baseUrl+`/sort?field=`+field);
  }

  getProductsByBrand(brand:string):Observable<Product[]>{
    return this.http.get<Product[]>(this.baseUrl+`/brand?brand=`+brand);
  }
}
