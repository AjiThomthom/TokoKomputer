package com.ppc.tokokomputer;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class CartManager {
    private static CartManager instance;
    private ArrayList<CartItem> cartItems;
    private SharedPreferences sharedPreferences;
    private static final String CART_PREFS = "cart_preferences";
    private static final String CART_ITEMS_KEY = "cart_items";

    private CartManager(Context context) {
        sharedPreferences = context.getSharedPreferences(CART_PREFS, Context.MODE_PRIVATE);
        loadCartItems();
    }

    public static synchronized CartManager getInstance(Context context) {
        if (instance == null) {
            instance = new CartManager(context);
        }
        return instance;
    }

    private void loadCartItems() {
        String json = sharedPreferences.getString(CART_ITEMS_KEY, null);
        if (json != null) {
            Gson gson = new Gson();
            Type type = new TypeToken<ArrayList<CartItem>>() {}.getType();
            cartItems = gson.fromJson(json, type);
        } else {
            cartItems = new ArrayList<>();
        }
    }

    private void saveCartItems() {
        Gson gson = new Gson();
        String json = gson.toJson(cartItems);
        sharedPreferences.edit().putString(CART_ITEMS_KEY, json).apply();
    }

    public void addToCart(Laptop laptop) {
        // Cek jika laptop sudah ada di cart
        for (int i = 0; i < cartItems.size(); i++) {
            CartItem item = cartItems.get(i);
            if (item.getLaptop().getModel().equals(laptop.getModel())) {
                item.increaseQuantity();
                saveCartItems();
                return;
            }
        }

        // Jika belum ada, tambahkan item baru
        cartItems.add(new CartItem(laptop, 1));
        saveCartItems();
    }

    public void removeFromCart(int position) {
        if (position >= 0 && position < cartItems.size()) {
            cartItems.remove(position);
            saveCartItems();
        }
    }

    public void updateQuantity(int position, int quantity) {
        if (position >= 0 && position < cartItems.size()) {
            if (quantity > 0) {
                cartItems.get(position).setQuantity(quantity);
            } else {
                cartItems.remove(position);
            }
            saveCartItems();
        }
    }

    public void clearCart() {
        cartItems.clear();
        saveCartItems();
    }

    public ArrayList<CartItem> getCartItems() {
        return new ArrayList<>(cartItems); // Return copy untuk menghindari concurrent modification
    }

    public int getCartItemCount() {
        int total = 0;
        for (CartItem item : cartItems) {
            total += item.getQuantity();
        }
        return total;
    }

    public int getCartTotalPrice() {
        int total = 0;
        for (CartItem item : cartItems) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public boolean isCartEmpty() {
        return cartItems.isEmpty();
    }
}