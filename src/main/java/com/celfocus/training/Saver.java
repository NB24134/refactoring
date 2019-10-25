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
    private static final List<ItemInfo> items = new ArrayList<>();

    public static class ItemInfo {

        public String name;

        public double valor;
    }

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

    public ItemInfo findItem(String name) {
        for (ItemInfo item : items) {
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
            if (item.getItemInfo().name == name) {
                return item;
            }
        }
        return null;
    }

    public void aIU(String user, String nameItem, int qt) {

        if (findUser(user) != null) {
            ShoppingCart cart = (getUserCart(findUser(user));
            if (cart != null) {
                ShoppingCartItem item = getShoppingCartItem(cart, nameItem);
                if (item != null) {
                    item.quantity += qt;
                } else {
                    ItemInfo ifo = null;
                    for (ItemInfo item : items) {
                        if (item.name.equals(nameItem)) {
                            ifo = item;
                        }
                    }

                    if (ifo != null) {
                        ShoppingCartItem s1 = new ShoppingCartItem();
                        s1.item = ifo;
                        s1.qt = qt;
                        if ( userFound.ifuserisolder
                 == true && (new Date().getYear() - userFound.bd.getYear() < 80) ) {
                            s1.discount = 0.2; 
                        } else if (userFound.ifuserisolder
                 == true) {
                            s1.discount = 0.1;
                        }
                    } else {

                    }
                    
                }
            }
        }
    }

    public void rIU(String user, String nameItem) {
        User userFound = null;
        for (User user1 : users) {
            if (user1.nameOfUser.equals(user)) {
                userFound = user1;
            }
        }

        if (userFound != null) {
            ShoppingCart found = null;
            for (ShoppingCart var : shoppingCarts) {
                if (var.user == userFound) {
                    found = var;
                }
            }

            if (found != null) {
                ShoppingCartItem scif = null;
                for (ShoppingCartItem s : found.itens) {
                    if (s.item.name == nameItem) {
                        scif = s;
                    }
                }

                if (scif != null) {
                    found.itens.remove(scif);
                }
            }
        }
    }

    public void citemifnotexists(String arg0, double v) {
        ItemInfo f = null;
        for (ItemInfo i : items){
            if (i.name == arg0) {
                f = i;
            }
        }

        if ( f != null ) {

        } else {
            ItemInfo ift = new ItemInfo();
            ift.name = arg0;
            ift.valor = v;
            items.add(ift);
        }
    }

} 