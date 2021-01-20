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

  constructor(private httpClient: HttpClient) { }

  getAdminBrandList(): Observable<ProductBrand[]>{
    return this.httpClient.get<ProductBrand[]>(`${this.brandUrl}`);
  }

}
