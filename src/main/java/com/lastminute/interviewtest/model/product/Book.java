package com.lastminute.interviewtest.model.product;

import java.math.BigDecimal;

import static com.lastminute.interviewtest.constants.RateConstants.NO_TAX_RATE;

public class Book extends Product{

    @Override
    public BigDecimal getBasicTaxRate() {
        return NO_TAX_RATE;
    }
}
