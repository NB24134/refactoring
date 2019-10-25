package com.celfocus.training;

public class ShoppingCartItem {

    public ItemInfo itemInfo;

    public int quantity;

    public double discount;

    public ShoppingCartItem(ItemInfo itemInfo, int quantity, double discount) {
        this.itemInfo = itemInfo;
        this.quantity = quantity;
        this.discount = discount;
    }

    public ItemInfo getItemInfo() {
        return itemInfo;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getDiscount() {
        return discount;
    }

    public void setItemInfo(ItemInfo itemInfo) {
        this.itemInfo = itemInfo;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void addQuantity(int quantity){

    }

}
