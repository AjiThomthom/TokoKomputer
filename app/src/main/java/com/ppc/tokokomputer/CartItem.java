package com.ppc.tokokomputer;

import java.io.Serializable;

public class CartItem implements Serializable {
    private Laptop laptop;
    private int quantity;
    private String addedDate;

    public CartItem(Laptop laptop, int quantity) {
        this.laptop = laptop;
        this.quantity = quantity;
        this.addedDate = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .format(new java.util.Date());
    }

    public Laptop getLaptop() { return laptop; }
    public void setLaptop(Laptop laptop) { this.laptop = laptop; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getAddedDate() { return addedDate; }
    public void setAddedDate(String addedDate) { this.addedDate = addedDate; }

    public int getTotalPrice() {
        return laptop.getPrice() * quantity;
    }

    public void increaseQuantity() {
        this.quantity++;
    }

    public void decreaseQuantity() {
        if (this.quantity > 1) {
            this.quantity--;
        }
    }
}