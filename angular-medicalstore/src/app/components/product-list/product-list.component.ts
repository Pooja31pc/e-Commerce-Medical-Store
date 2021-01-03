import { Component, OnInit } from '@angular/core';
import {ProductService} from "../../services/product.service";
import {Product} from "../../common/product";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products: Product[];

  constructor(private _productService: ProductService) { }

  ngOnInit() {
    this.listProducts();
  }

  listProducts() {
    this._productService.getProducts().subscribe(
      data => this.products = data
    )
  }

}