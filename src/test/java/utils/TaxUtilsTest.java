package utils;


import com.lastminute.interviewtest.utils.TaxUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class TaxUtilsTest {

    @Test
    public void calculateTaxTest(){
        Assertions.assertEquals(new BigDecimal("1.05"), TaxUtils.calculateTax(new BigDecimal("10.50"), new BigDecimal("10")));
        Assertions.assertEquals(new BigDecimal("2.80"), TaxUtils.calculateTax(new BigDecimal("27.99"), new BigDecimal("10")));
        Assertions.assertEquals(new BigDecimal("0.00"), TaxUtils.calculateTax(new BigDecimal("27.99"), BigDecimal.ZERO));
        Assertions.assertEquals(new BigDecimal("0.60"), TaxUtils.calculateTax(new BigDecimal("11.25"), new BigDecimal("5")));
        Assertions.assertEquals(new BigDecimal("2.40"), TaxUtils.calculateTax(new BigDecimal("47.50"), new BigDecimal("5")));
        Assertions.assertEquals(new BigDecimal("4.75"), TaxUtils.calculateTax(new BigDecimal("47.50"), new BigDecimal("10")));
    }
}
