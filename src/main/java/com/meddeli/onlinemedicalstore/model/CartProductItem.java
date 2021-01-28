package com.meddeli.onlinemedicalstore.model;

import javax.persistence.*;

@Entity
@Table(name="tbl_cartproductitem")
public class CartProductItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cartitemId;
    private int quantity;

    @ManyToOne
    @JoinColumn(name="cartId", nullable=false)
    private Cart cart;


    @OneToOne(targetEntity= Product.class)
    private Product product;

    public int getCartitemId() {
        return cartitemId;
    }

    public void setCartitemId(int cartitemId) {
        this.cartitemId = cartitemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public CartProductItem() {
    }

    public CartProductItem(int cartitemId, int quantity, Cart cart, Product product) {
        this.cartitemId = cartitemId;
        this.quantity = quantity;
        this.cart = cart;
        this.product = product;
    }

    public CartProductItem(int quantity, Cart cart, Product product) {
        this.quantity = quantity;
        this.cart = cart;
        this.product = product;
    }

}
