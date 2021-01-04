import { Component, OnInit } from '@angular/core';
import {ProductService} from "../../services/product.service";
import {Product} from "../../common/product";
import {ActivatedRoute} from "@angular/router";
import {CartItem} from "../../common/cart-item";
import {CartService} from "../../services/cart.service";

@Component({
  selector: 'app-product-list',
  //templateUrl: './product-list.component.html',
  templateUrl: './product-grid.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products: Product[];
  currentCategoryId: number;
  searchMode: boolean;

  constructor(private _productService: ProductService,
              private _activatedRoute: ActivatedRoute,
              private _cartService: CartService) { }

  ngOnInit() {
    this._activatedRoute.paramMap.subscribe(()=>{
      this.listProducts();
    })
  }

  listProducts(){
    this.searchMode = this._activatedRoute.snapshot.paramMap.has('keyword');

    if(this.searchMode){
      this.handleSearchProducts();
    }else{
      this.handleListProducts();
    }

  }

  handleListProducts(){

    const hasCategoryId: boolean = this._activatedRoute.snapshot.paramMap.has('id');

    if(hasCategoryId){
      this.currentCategoryId = +this._activatedRoute.snapshot.paramMap.get('id');
    }else {
      this.currentCategoryId = 1;
    }


    this._productService.getProducts(this.currentCategoryId).subscribe(
      data => this.products = data
    )

  }

  handleSearchProducts(){
    const keyword: string = this._activatedRoute.snapshot.paramMap.get('keyword');

    this._productService.searchProducts(keyword).subscribe(
      data => {
        this.products = data;
      }
    )
  }

  addToCart(product: Product){
    console.log(`product name: ${product.name}, and price: ${product.unitPrice}`);
    const cartItem = new CartItem(product);
    this._cartService.addToCart(cartItem);
  }


}
