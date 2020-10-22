package com.lastminute.interviewtest.model.product;

import com.lastminute.interviewtest.constants.RateConstants;

import java.math.BigDecimal;

public class Medicinal extends Product {

    @Override
    public BigDecimal getBasicTaxRate() {
        return RateConstants.NO_TAX_RATE;
    }
}
