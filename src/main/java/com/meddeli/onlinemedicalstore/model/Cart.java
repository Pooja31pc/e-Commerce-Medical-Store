package com.meddeli.onlinemedicalstore.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="tbl_cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cartId;
    private Date orderedtime;
    private boolean ordered;

    @OneToOne(targetEntity= User.class)
    private User user;

    @OneToMany(mappedBy="cart")
    private Set<CartProductItem> cartfoodItem;

    public Cart(boolean ordered, User user) {
        this.ordered = ordered;
        this.user = user;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public Date getOrderedtime() {
        return orderedtime;
    }

    public void setOrderedtime(Date orderedtime) {
        this.orderedtime = orderedtime;
    }

    public boolean isOrdered() {
        return ordered;
    }

    public void setOrdered(boolean ordered) {
        this.ordered = ordered;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<CartProductItem> getCartfoodItem() {
        return cartfoodItem;
    }

    public void setCartfoodItem(Set<CartProductItem> cartfoodItem) {
        this.cartfoodItem = cartfoodItem;
    }
    public Cart() {
    }
    public Cart(int cartId, Date orderedtime, boolean ordered, User user, Set<CartProductItem> cartfoodItem) {
        this.cartId = cartId;
        this.orderedtime = orderedtime;
        this.ordered = ordered;
        this.user = user;
        this.cartfoodItem = cartfoodItem;
    }

}
