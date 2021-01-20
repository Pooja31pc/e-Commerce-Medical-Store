import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import {RouterModule, Routes} from "@angular/router";

import { AppComponent } from './app.component';
import { CartDetailsComponent } from './components/cart-details/cart-details.component';
import { CartStatusComponent } from './components/cart-status/cart-status.component';
import { CheckoutComponent } from './components/checkout/checkout.component';
import { OrderedDetailsComponent } from './components/ordered-details/ordered-details.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { ProductCategoryComponent } from './components/product-category/product-category.component';
import { ProductDetailsComponent } from './components/product-details/product-details.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import { SearchComponent } from './components/search/search.component';
import {ProductService} from "./services/product.service";
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { ProductBrandComponent } from './components/product-brand/product-brand.component';
import { UserLoginComponent } from './components/user-login/user-login.component';
import { UserRegisterComponent } from './components/user-register/user-register.component';
import { AdminProductListComponent } from './components/admin-product-list/admin-product-list.component';
import { AdminProductCreateComponent } from './components/admin-product-create/admin-product-create.component';
import { AdminProductDetailsComponent } from './components/admin-product-details/admin-product-details.component';
import { AdminBrandListComponent } from './components/admin-brand-list/admin-brand-list.component';
import { AdminCategoryListComponent } from './components/admin-category-list/admin-category-list.component';
import { AdminDeleteProductComponent } from './components/admin-delete-product/admin-delete-product.component';
import { AdminUpdateProductComponent } from './components/admin-update-product/admin-update-product.component';



const routes: Routes = [
  {path: 'ordered-details', component: OrderedDetailsComponent},
  {path: 'admincreate', component: AdminProductCreateComponent},
  {path: 'adminproduct', component: AdminProductListComponent},
  {path: 'adminproductdetails/:id', component: AdminProductDetailsComponent},
  {path: 'adminbrand', component: AdminBrandListComponent},
  {path: 'admincategory', component: AdminCategoryListComponent},
  {path: 'updateproduct/:id', component: AdminUpdateProductComponent},
  {path: 'login', component: UserLoginComponent},
  {path: 'register', component: UserRegisterComponent},
  {path: 'checkout', component: CheckoutComponent},
  {path: 'cart-details', component: CartDetailsComponent},
  {path: 'products/:id', component: ProductDetailsComponent},
  {path: 'products', component: ProductListComponent},
  {path: 'search/:keyword',component: ProductListComponent},
  {path: 'category/:category_id', component: ProductListComponent},
  {path: 'brand/:brand_id', component: ProductListComponent},
  {path: '', redirectTo: '/products', pathMatch: 'full'},
  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    CartDetailsComponent,
    CartStatusComponent,
    CheckoutComponent,
    OrderedDetailsComponent,
    PageNotFoundComponent,
    ProductCategoryComponent,
    ProductDetailsComponent,
    ProductListComponent,
    SearchComponent,
    ProductBrandComponent,
    UserLoginComponent,
    UserRegisterComponent,
    AdminProductListComponent,
    AdminProductCreateComponent,
    AdminProductDetailsComponent,
    AdminBrandListComponent,
    AdminCategoryListComponent,
    AdminDeleteProductComponent,
    AdminUpdateProductComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [
    ProductService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
