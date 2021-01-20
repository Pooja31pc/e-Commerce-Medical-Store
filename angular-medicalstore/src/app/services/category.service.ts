import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {ProductBrand} from "../common/product-brand";
import {HttpClient} from "@angular/common/http";
import {ProductCategory} from "../common/product-category";

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private categoryUrl = "http://localhost:8484/admin/category";

  constructor(private httpClient: HttpClient) { }

  getAdminCategoryList(): Observable<ProductCategory[]> {
    return this.httpClient.get<ProductCategory[]>(`${this.categoryUrl}`);
  }
}
