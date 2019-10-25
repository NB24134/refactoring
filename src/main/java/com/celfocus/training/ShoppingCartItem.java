package com.celfocus.training;

public class ShoppingCartItem {

    public Item item;

    public int quantity;

    public double discount;

    public ShoppingCartItem(Item item, int quantity, double discount) {
        this.item = item;
        this.quantity = quantity;
        this.discount = discount;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getDiscount() {
        return discount;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void addQuantity(int quantity){
        this.quantity += quantity;
    }

}
