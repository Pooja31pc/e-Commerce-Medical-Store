import { Component, OnInit } from '@angular/core';
import {Product} from "../../common/product";

@Component({
  selector: 'app-admin-delete-product',
  templateUrl: './admin-delete-product.component.html',
  styleUrls: ['./admin-delete-product.component.css']
})
export class AdminDeleteProductComponent implements OnInit {

  products: Product[];

  constructor() { }

  ngOnInit(): void {
  }



}
