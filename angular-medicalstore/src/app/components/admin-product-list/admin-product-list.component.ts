import { Component, OnInit } from '@angular/core';
import {Product} from "../../common/product";
import {ProductService} from "../../services/product.service";

@Component({
  selector: 'app-admin-product-list',
  templateUrl: './admin-product-list.component.html',
  styleUrls: ['./admin-product-list.component.css']
})
export class AdminProductListComponent implements OnInit {

  products: Product[];

  constructor(private productService: ProductService
  ) { }

  ngOnInit() {
    this.getAdminProducts();
  }

 private getAdminProducts(){
    this.productService.getAdminList().subscribe(data => {
      this.products = data;
    })
 }

}
