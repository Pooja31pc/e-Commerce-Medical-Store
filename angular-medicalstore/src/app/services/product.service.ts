import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from "rxjs";
import {map} from "rxjs/operators";
import {Product} from "../common/product";
import {ProductCategory} from "../common/product-category";

@Injectable({
  providedIn: 'root'
})

export class ProductService {

  private baseUrl = "http://localhost:8484/products";
  private categoryUrl = "http://localhost:8484/product-category";


  constructor(private httpClient: HttpClient) { }

  getProducts(theCategoryId: number): Observable<Product[]>{

    const searchUrl = `${this.baseUrl}/search/categoryid?id=${theCategoryId}`;

    return this.getProductsList(searchUrl);

  }

  private getProductsList(searchUrl: string): Observable<Product[]> {
    return this.httpClient.get<GetResponseProducts>(searchUrl).pipe(
      map(response => response._embedded.products)
    );
  }

  getProductCategories(): Observable<ProductCategory[]>{

    return this.httpClient.get<GetResponseProductCategory>(this.categoryUrl).pipe(
      map(response => response._embedded.productcategory)
    );

  }

  searchProducts(keyword: string): Observable<Product[]>{

    const searchUrl = `${this.baseUrl}/search/searchbykeyword?name=${keyword}`;

    return this.getProductsList(searchUrl);

  };

  get(productId: number): Observable<Product>{
    const productDetailsUrl = `${this.baseUrl}/${productId}`;
    return this.httpClient.get<Product>(productDetailsUrl);
  }

}


interface GetResponseProducts{
  _embedded: {
    products: Product[];
  }
}
interface GetResponseProductCategory{
  _embedded: {
    productcategory: ProductCategory[];
  }
}

  interface GetResponseProducts{
    _embedded: {
      products: Product[];
    }
}
