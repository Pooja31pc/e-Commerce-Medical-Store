import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
// import { CartDetailsComponent } from './components/cart-details/cart-details.component';
// import { CartStatusComponent } from './components/cart-status/cart-status.component';
// import { CheckoutComponent } from './components/checkout/checkout.component';
// import { OrderedDetailsComponent } from './components/ordered-details/ordered-details.component';
// import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
// import { ProductCategoryComponent } from './components/product-category/product-category.component';
// import { ProductDetailsComponent } from './components/product-details/product-details.component';
 import { ProductListComponent } from './components/product-list/product-list.component';
// import { SearchComponent } from './components/search/search.component';
 import {ProductService} from "./services/product.service";


@NgModule({
  declarations: [
    AppComponent,
    // CartDetailsComponent,
    // CartStatusComponent,
    // CheckoutComponent,
    // OrderedDetailsComponent,
    // PageNotFoundComponent,
    // ProductCategoryComponent,
    // ProductDetailsComponent,
    ProductListComponent,
    //SearchComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [
    ProductService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
