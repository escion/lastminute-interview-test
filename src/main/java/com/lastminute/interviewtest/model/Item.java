package com.lastminute.interviewtest.model;

import com.lastminute.interviewtest.model.product.Product;

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

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
