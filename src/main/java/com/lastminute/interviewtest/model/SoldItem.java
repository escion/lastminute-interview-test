package com.lastminute.interviewtest.model;

import java.math.BigDecimal;

public class SoldItem {
    int quantity;
    String name;
    BigDecimal price;

    public SoldItem(int quantity, String name, BigDecimal price) {
        this.quantity = quantity;
        this.name = name;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
