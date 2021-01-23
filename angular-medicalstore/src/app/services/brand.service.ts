import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../common/product";
import {ProductBrand} from "../common/product-brand";

@Injectable({
  providedIn: 'root'
})
export class BrandService {

  private brandUrl = "http://localhost:8484/admin/brand";
  private deleteBrandUrl = "http://localhost:8484/admin/deletebrand";
  private adminCreateBrandUrl = "http://localhost:8484/admin/addbrand";

  constructor(private httpClient: HttpClient) { }

  getAdminBrandList(): Observable<ProductBrand[]>{
    return this.httpClient.get<ProductBrand[]>(`${this.brandUrl}`);
  }

  deleteBrandById(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.deleteBrandUrl}?id=${id}`);
  }

  createAdminBrand(brand: ProductBrand): Observable<Object>{
    // let alreadyExistsCategory: boolean = false;
    // let existingCategory: ProductCategory = undefined;
    // if()
    return this.httpClient.post(`${this.adminCreateBrandUrl}`, brand);
  }


}
