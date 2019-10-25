package com.celfocus.training;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    public User user;

    public List<ShoppingCartItem> items;

    public ShoppingCart(User user, List<ShoppingCartItem> items) {
        this.user = user;
        this.items = items;
    }

    public ShoppingCart(User user) {
        this.user = user;
        this.items = new ArrayList<>();
    }

    public User getUser() {
        return user;
    }

    public List<ShoppingCartItem> getItems() {
        return items;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setItems(List<ShoppingCartItem> items) {
        this.items = items;
    }

    public void removeShoppingCartItem(ShoppingCartItem sci){
        for (ShoppingCartItem cartItem : this.getItems()) {
            if (cartItem.getItem() == sci.getItem()) {
                this.getItems().remove(sci);
            }
        }
    }

}
