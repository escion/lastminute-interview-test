package com.lastminute.interviewtest.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Receipt {
    List<SoldItem> items;
    BigDecimal salesTaxes;
    BigDecimal total;

    private Receipt(){

    }

    public static Receipt emptyReceipt(){
        Receipt receipt = new Receipt();
        receipt.salesTaxes = BigDecimal.ZERO;
        receipt.total = BigDecimal.ZERO;
        receipt.items = new ArrayList<>();
        return receipt;
    }

    public List<SoldItem> getItems() {
        return items;
    }

    public BigDecimal getSalesTaxes() {
        return salesTaxes;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void addItem(int quantity, String name, BigDecimal price){
        items.add(new SoldItem(quantity, name, price));
    }

    public void addTax(BigDecimal tax){
        salesTaxes = salesTaxes.add(tax);
    }

    public void addTotal(BigDecimal value){
        total = total.add(value);
    }
}
