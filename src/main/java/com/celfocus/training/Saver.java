package com.celfocus.training;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Temos 4 entidades em nosso projeto User, ShoppingCart, ShoppingCartItem e ItemInfo
 */
public class Saver {

    private static final List<User> users = new ArrayList<>();
    private static final List<ShoppingCart> shoppingCarts = new ArrayList<>();
    private static final List<Item> items = new ArrayList<>();

    public User saveOrUpdateUser(String name, Date birthDate, boolean userIsOver18) {
        if (userExists(name)) {
            User user = findUser(name);
            user.updateUser(name, birthDate, userIsOver18);
            if(getUserCart(user) == null){
                shoppingCarts.add(new ShoppingCart(user));
            }
            users.add(user);
            return user;
        } else {
            User user = new User(name, birthDate, userIsOver18);
            users.add(user);
            shoppingCarts.add(new ShoppingCart(user, new ArrayList<>()));
            return user;
        }
    }

    private boolean userExists(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    private User findUser(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public ShoppingCart getUserCart(User user){
        for (ShoppingCart cart : shoppingCarts) {
            if (cart.user == user) {
                return cart;
            }
        }
        return null;
    }

    public Item findItem(String name) {
        for (Item item : items) {
            if (item.name.equals(name)) {
                return item;
            }
        }
        return null;
    }

    public void deleteUserOrNot(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                users.remove(user);
            }
        }
    }

    public ShoppingCartItem getShoppingCartItem(ShoppingCart cart, String name){
        for (ShoppingCartItem item : cart.getItems()) {
            if (item.getItem().name == name) {
                return item;
            }
        }
        return null;
    }

    public Item getItemFromInventory(String name) {
        for (Item item : items) {
            if (item.name.equals(name)) {
                return item;
            }
        }
        return null;
    }

    public ShoppingCartItem getShoppingCartItem(String userName, String itemName){
        User user = findUser(userName);
        if (user!= null) {
            ShoppingCart cart = (getUserCart(user));
            if (cart != null) {
                ShoppingCartItem item = getShoppingCartItem(cart, itemName);
                if (item != null){
                    return item;
                }
            }
        }
        return null;
    }

    public void applyItemDiscount(String userName, String nameItem, int qt) {
        ShoppingCartItem cartItem = getShoppingCartItem(userName, nameItem);
        if(cartItem != null){
            cartItem.addQuantity(qt);
        }else{
            Item item = getItemFromInventory(nameItem);
            if (item != null) {
                if (this.findUser(userName).userIsOver18 && (new Date().getYear() - this.findUser(userName).getBirthDate().getYear() < 80) ) {
                    ShoppingCartItem s1 = new ShoppingCartItem(item, qt, 0.2);
                } else if (this.findUser(userName).userIsOver18 == true) {
                    ShoppingCartItem s1 = new ShoppingCartItem(item, qt, 0.2);
                }
            }
        }
    }

    public void removeShoppingCartItem(String user, String nameItem) {
       ShoppingCartItem cartItem = this.getShoppingCartItem(user, nameItem);
        ShoppingCart cart = this.getUserCart(this.findUser(user));
        if(cartItem != null){
            cart.removeShoppingCartItem(cartItem);
       }
    }

    public void createItem(String name, double value) {
        if ( findItem(name) == null ) {
            items.add(new Item(name, value));
        }
    }

} 