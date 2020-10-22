package com.lastminute.interviewtest.factory.supplier;

import com.lastminute.interviewtest.model.product.Book;
import com.lastminute.interviewtest.model.product.Product;

import java.util.function.Supplier;

public class BookSupplier implements Supplier<Product> {
    @Override
    public Product get() {
        return new Book();
    }
}
