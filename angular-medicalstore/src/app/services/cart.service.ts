import { Injectable } from '@angular/core';
import {CartItem} from "../common/cart-item";
import {Observable, Subject} from "rxjs";
import {Product} from "../common/product";
import {ProductService} from "./product.service";

@Injectable({
  providedIn: 'root'
})
export class CartService {

  cartItems: CartItem[] = [];
  totalPrice: Subject<number> = new Subject<number>();
  totalQuantity: Subject<number> = new Subject<number>();

  constructor(private  productService: ProductService) { }

  addToCart(theCartItem: CartItem){
    //check whether the product/item is already in the cart

    let alreadyExistsInCart: boolean = false;
    let existingCartItem: CartItem = undefined;

    if(this.cartItems.length > 0) {

      existingCartItem = this.cartItems.find(tempCartItem => tempCartItem.id === theCartItem.id);


      alreadyExistsInCart = (existingCartItem != undefined)

    }

    // increase_quantity(temp_package){
    //   if(temp_package.limit == temp_package.quantity){
    //     return alert("Can't add more")
      // }else{
    //     temp_package.quantity++
    //     this.Price += temp_package.price
    //   }
    // }

    if(alreadyExistsInCart) {
      //increment the quantity
      let temp: Product = null
      this.productService.get(Number(existingCartItem.id)).subscribe(
        data => {temp = data

          if(existingCartItem.quantity>=temp.unitsInStock){
            return alert("Dont add more")
          }
          existingCartItem.quantity++;
        }
      )
    }else{
      //add to the cart item array
      this.cartItems.push(theCartItem);
    }

    this.calculateTotalPrice();

  }

  calculateTotalPrice(){

    let totalPriceValue: number = 0;
    let totalQuantityValue: number = 0;

    for(let currentCartItem of this.cartItems){

      totalPriceValue += currentCartItem.quantity * currentCartItem.unitPrice;
      totalQuantityValue += currentCartItem.quantity;

    }

    console.log(`total price: ${totalPriceValue}, Total quantity: ${totalQuantityValue}`);

    this.totalPrice.next(totalPriceValue);
    this.totalQuantity.next(totalQuantityValue);


  }

  decrementQuantity(cartItem: CartItem) {
    cartItem.quantity--;

    if(cartItem.quantity === 0) {
      this.remove(cartItem);
    }else {
      this.calculateTotalPrice();
    }

    this.calculateTotalPrice();
  }

  remove(cartItem: CartItem) {
    const itemIndex = this.cartItems.findIndex((tempCartItem) => tempCartItem.id === cartItem.id);

    if(itemIndex > -1) {
      this.cartItems.splice(itemIndex, 1);
      this.calculateTotalPrice();
    }
  }

  emptyCart() {
    // for(let currentCartItem of this.cartItems){

    //   this.remove(currentCartItem);

    // }

    for(var i=0;i<CartItem.length;i++){
      this.cartItems.splice(CartItem[i]);
    }

    this.calculateTotalPrice();
  }


}
