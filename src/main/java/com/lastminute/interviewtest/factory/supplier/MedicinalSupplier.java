package com.lastminute.interviewtest.factory.supplier;

import com.lastminute.interviewtest.model.product.Medicinal;
import com.lastminute.interviewtest.model.product.Product;

import java.util.function.Supplier;

public class MedicinalSupplier implements Supplier<Product> {
    @Override
    public Product get() {
        return new Medicinal();
    }
}
