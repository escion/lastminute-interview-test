package com.lastminute.interviewtest.factory.supplier;

import com.lastminute.interviewtest.model.product.Food;
import com.lastminute.interviewtest.model.product.Product;

import java.util.function.Supplier;

public class FoodSupplier implements Supplier<Product> {
    @Override
    public Product get() {
        return new Food();
    }
}
