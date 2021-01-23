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
  private deleteCategoryUrl = "http://localhost:8484/admin/deletecategory";
  private adminCreateCategoryUrl = "http://localhost:8484/admin/addcategory"

  constructor(private httpClient: HttpClient) { }

  getAdminCategoryList(): Observable<ProductCategory[]> {
    return this.httpClient.get<ProductCategory[]>(`${this.categoryUrl}`);
  }

  deleteCategoryById(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.deleteCategoryUrl}?id=${id}`);
  }

  createAdminCategory(category: ProductCategory ): Observable<Object>{
    // let alreadyExistsCategory: boolean = false;
    // let existingCategory: ProductCategory = undefined;
    // if()
    return this.httpClient.post(`${this.adminCreateCategoryUrl}`, category);
  }

}
