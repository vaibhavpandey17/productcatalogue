package com.ProductCatalogue.ProductCatalogue.Model;

public class Availability {

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Availability{" +
                "inStock=" + inStock +
                ", quantity=" + quantity +
                '}';
    }

    private boolean inStock;
    private int quantity;

    public Availability(boolean inStock, int quantity) {
        this.inStock = inStock;
        this.quantity = quantity;
    }
}
