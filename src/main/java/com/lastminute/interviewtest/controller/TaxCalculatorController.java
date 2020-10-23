package com.lastminute.interviewtest.controller;

import com.lastminute.interviewtest.factory.ProductFactory;
import com.lastminute.interviewtest.model.Item;
import com.lastminute.interviewtest.model.Receipt;
import com.lastminute.interviewtest.model.product.Product;
import com.lastminute.interviewtest.utils.FileUtils;
import com.lastminute.interviewtest.utils.TaxUtils;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TaxCalculatorController {

    /**
     * Calculate the receipt with given items
     * @param items: items to be purchased
     * @return receipt with items, taxes and total price
     */
    public static Receipt getReceipt(List<Item> items){
        Receipt receipt = Receipt.emptyReceipt();
        if(items != null){
            items.forEach(item -> {
                BigDecimal basicTax = TaxUtils.calculateTax(item.getProduct().getPrice(), item.getProduct().getBasicTaxRate());
                BigDecimal additionalTax = TaxUtils.calculateTax(item.getProduct().getPrice(), item.getProduct().getSalesTaxRate());
                BigDecimal price = item.getProduct().getPrice().add(basicTax).add(additionalTax);
                BigDecimal quantity = new BigDecimal(item.getQuantity());
                receipt.addTax(basicTax.multiply(quantity));
                receipt.addTax(additionalTax.multiply(quantity));
                receipt.addItem(item.getQuantity(), item.getProduct().getName(), price);
                receipt.addTotal(price.multiply(quantity));
            });
        }
        return receipt;
    }

    /**
     * Create an item given string parameters
     * @param id
     * @param name
     * @param price
     * @param imported
     * @param quantity
     * @return
     */
    public static Item getItem(String id, String name, String price, String imported, String quantity){
        Item item = null;
        Product product = ProductFactory.getProduct(id);
        product.setName(name);
        try{
            product.setPrice(new BigDecimal(price));
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException("price must be numeric");
        }
        product.setImported(Boolean.valueOf(imported));
        try{
            item = new Item(Integer.valueOf(quantity), product);
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException("quantity must be numeric");
        }
        return item;
    }
}
