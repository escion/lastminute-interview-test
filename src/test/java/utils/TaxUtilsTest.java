package utils;


import com.lastminute.interviewtest.utils.TaxUtils;
import org.junit.Test;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.assertEquals;

public class TaxUtilsTest {

    @Test
    public void calculateTaxTest(){
        assertEquals(new BigDecimal("1.05"), TaxUtils.calculateTax(new BigDecimal("10.50"), new BigDecimal("10")));
        assertEquals(new BigDecimal("2.80"), TaxUtils.calculateTax(new BigDecimal("27.99"), new BigDecimal("10")));
        assertEquals(new BigDecimal("0.00"), TaxUtils.calculateTax(new BigDecimal("27.99"), BigDecimal.ZERO));
        assertEquals(new BigDecimal("0.60"), TaxUtils.calculateTax(new BigDecimal("11.25"), new BigDecimal("5")));
        assertEquals(new BigDecimal("2.40"), TaxUtils.calculateTax(new BigDecimal("47.50"), new BigDecimal("5")));
        assertEquals(new BigDecimal("4.75"), TaxUtils.calculateTax(new BigDecimal("47.50"), new BigDecimal("10")));
    }
}
