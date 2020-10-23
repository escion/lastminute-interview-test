package com.lastminute.interviewtest.factory;

import com.lastminute.interviewtest.factory.supplier.BookSupplier;
import com.lastminute.interviewtest.factory.supplier.FoodSupplier;
import com.lastminute.interviewtest.factory.supplier.MedicinalSupplier;
import com.lastminute.interviewtest.factory.supplier.OtherProductSupplier;
import com.lastminute.interviewtest.model.product.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ProductFactory {

    final static Map<String, Supplier<? extends Product>> factory = new HashMap<>();
    static{
        factory.put("book", new BookSupplier());
        factory.put("food", new FoodSupplier());
        factory.put("medicinal", new MedicinalSupplier());
        factory.put("other", new OtherProductSupplier());
    }

    public static Product getProduct(String id){
        Supplier<? extends Product> supplier = factory.get(id);
        if(supplier == null)
            throw new IllegalArgumentException("No product registered with id: " + id);
        return supplier.get();
    }

    public static void registerProduct(String id, Supplier<? extends Product> supplier){
        factory.put(id, supplier);
    }
}
