import { Component, OnInit } from '@angular/core';
import { Product } from '../classes/product';
import { ProductService } from '../services/product/product.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  constructor(private productService: ProductService) { }

  products !: Product[];
  product: Product = new Product();
  min !: number;
  max !: number;

  updateBind: boolean = false;
  filterForName: boolean = false;
  filterForRange: boolean = false;
  brand!:string;
  filterForBrand:boolean=false;


  ngOnInit(): void {
    this.getAllProducts();
  }


  isFormValid():boolean{
    return(
       !!this.product.productId&&
       !!this.product.productName&&
       !!this.product.unitPrice&&
       !!this.product.colour&&
       !!this.product.brand&&
       !!this.product.size&&
       !!this.product.rating
       
       );
    
   }

  goBackToAdd(){
    this.updateBind = false;
    this.filterForName = false;
    this.filterForRange = false;
    this.filterForBrand = false;
    this.product = new Product();
  }

  //Getting All the Products
  getAllProducts() {
    this.productService.getAllProducts().subscribe(data => {
      this.products = data;
    })
  }

  changeBrand(m: any): void {
    this.brand = m.target.value;
  }

  //Add Product
  addProduct() {
    this.productService.addProduct(this.product).subscribe(data => {
      console.log(data);

    },
      (err) => {
        this.getAllProducts();
        alert("Record Created Successfully");

      })
  }

  //Get Product to Update
  getProductToUpdate(prod: Product) {
    this.updateBind = true;
    this.product.productId = prod.productId;
    this.product.productName = prod.productName;
    this.product.brand = prod.brand;
    this.product.colour = prod.colour;
    this.product.size = prod.size;
    this.product.unitPrice = prod.unitPrice;
    this.product.rating = prod.rating;
  }

  //Update Product
  updateProduct() {
    this.productService.updateProduct(this.product).subscribe(data => {
      console.log(data);

    },
      (err) => {
        this.getAllProducts();
        alert("Record Updated Successfully");

      })
  }

  //Delete Product
  deleteProduct(product: Product) {
    this.productService.deleteProduct(product).subscribe(() => { }, (err) => {
      this.getAllProducts();
      alert("Record Deleted Successfully");
    });
  }

  getFilterForName() {
    this.filterForName = true;
  }

  getFilterForBrand(){
    this.filterForBrand = true;
  }

  //Search Products Matching product name
  getProductsByName() {
    this.productService.getProductsByName(this.product.productName).subscribe(data => {
      this.products = data;
    })
  }

  getFilterForRange() {
    this.filterForRange = true;
  }

  getProductsByPriceRange() {
    this.productService.getProductByMinMax(this.min, this.max).subscribe(data => {
      this.products = data;
    })
  }

  sortByField(field: string) {
    this.productService.getSortedProductsByField(field).subscribe(data => {
      this.products = data;
    })
  }
  getProductsByBrand(){
    this.productService.getProductsByBrand(this.brand).subscribe(data=>{
      this.products=data;
    })
  }
}
