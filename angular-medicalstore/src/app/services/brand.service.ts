import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../common/product";
import {ProductBrand} from "../common/product-brand";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class BrandService {

  //private brandUrl = "http://localhost:8484/admin/brand";
  private brandUrl = environment.apiUrl+'/admin/brand';
  //private deleteBrandUrl = "http://localhost:8484/admin/deletebrand";
  private deleteBrandUrl = environment.apiUrl+'/admin/deletebrand';
  //private adminCreateBrandUrl = "http://localhost:8484/admin/addbrand";
  private adminCreateBrandUrl = environment.apiUrl+'/admin/addbrand';

  constructor(private httpClient: HttpClient) { }

  getAdminBrandList(): Observable<ProductBrand[]>{
    return this.httpClient.get<ProductBrand[]>(`${this.brandUrl}`);
  }

  deleteBrandById(id: number): Observable<Object>{
    return this.httpClient.get(`${this.deleteBrandUrl}?id=${id}`);
  }

  createAdminBrand(brand: ProductBrand): Observable<Object>{
    // let alreadyExistsCategory: boolean = false;
    // let existingCategory: ProductCategory = undefined;
    // if()
    return this.httpClient.post(`${this.adminCreateBrandUrl}`, brand);
  }


}
