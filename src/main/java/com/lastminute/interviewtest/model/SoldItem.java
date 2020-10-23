package com.lastminute.interviewtest.model;

import java.math.BigDecimal;

/**
 * Item to be sold
 */
public class SoldItem {
    int quantity;
    String name;
    BigDecimal finalPrice;

    public SoldItem(int quantity, String name, BigDecimal finalPrice) {
        this.quantity = quantity;
        this.name = name;
        this.finalPrice = finalPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }
}
