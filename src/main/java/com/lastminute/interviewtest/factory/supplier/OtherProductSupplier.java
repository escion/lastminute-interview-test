package com.lastminute.interviewtest.factory.supplier;

import com.lastminute.interviewtest.model.product.OtherProduct;
import com.lastminute.interviewtest.model.product.Product;

import java.util.function.Supplier;

public class OtherProductSupplier implements Supplier<Product> {
    @Override
    public Product get() {
        return new OtherProduct();
    }
}
