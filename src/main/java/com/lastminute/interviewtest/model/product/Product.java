package com.lastminute.interviewtest.model.product;

import java.math.BigDecimal;

import static com.lastminute.interviewtest.constants.RateConstants.*;

public abstract class Product {
    String name;
    BigDecimal price;
    boolean imported;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setImported(boolean imported) {
        this.imported = imported;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean isImported() {
        return imported;
    }

    public BigDecimal getBasicTaxRate(){
        return BASIC_TAX_RATE;
    }

    public BigDecimal getSalesTaxRate(){
        if(imported)
            return IMPORTED_SALES_TAX_RATE;
        return NO_TAX_RATE;
    }
}
