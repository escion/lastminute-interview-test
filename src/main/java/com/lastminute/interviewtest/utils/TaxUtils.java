package com.lastminute.interviewtest.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.lastminute.interviewtest.constants.RateConstants.ONE_HUNDRED;
import static com.lastminute.interviewtest.constants.RateConstants.ROUNDING_RATE;

public class TaxUtils {

    public static BigDecimal calculateTax(BigDecimal price, BigDecimal rate){
        return roundUp(price.multiply(rate).divide(ONE_HUNDRED));
    }

    public static BigDecimal roundUp(BigDecimal value){
        return round(value, ROUNDING_RATE, RoundingMode.UP);
    }

    private static BigDecimal round(BigDecimal value, BigDecimal rounding, RoundingMode mode){
        BigDecimal divided = value.divide(rounding, 0, mode);
        return divided.multiply(rounding);
    }
}
