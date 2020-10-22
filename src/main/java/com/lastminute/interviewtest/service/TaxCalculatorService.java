package com.lastminute.interviewtest.service;

import com.lastminute.interviewtest.model.Item;
import com.lastminute.interviewtest.model.Receipt;
import com.lastminute.interviewtest.utils.TaxUtils;

import java.math.BigDecimal;
import java.util.List;

public class TaxCalculatorService {

    public static Receipt getReceipt(List<Item> items){
        Receipt receipt = Receipt.emptyReceipt();
        items.forEach(item -> {
            BigDecimal basicTax = TaxUtils.calculateTax(item.getProduct().getPrice(), item.getProduct().getBasicTaxRate());
            BigDecimal additionalTax = TaxUtils.calculateTax(item.getProduct().getPrice(), item.getProduct().getSalesTaxRate());
            BigDecimal price = item.getProduct().getPrice().add(basicTax).add(additionalTax);
            receipt.addTax(basicTax);
            receipt.addTax(additionalTax);
            receipt.addItem(item.getQuantity(), item.getProduct().getName(), price);
            receipt.addTotal(price);
        });
        return receipt;
    }
}
