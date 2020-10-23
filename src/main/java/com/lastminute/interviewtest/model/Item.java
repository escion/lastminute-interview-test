package com.lastminute.interviewtest.model;

import com.lastminute.interviewtest.model.product.Product;

/**
 * Item to be purchased
 */
public class Item {
    int quantity;
    Product product;

    public Item(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }
}
