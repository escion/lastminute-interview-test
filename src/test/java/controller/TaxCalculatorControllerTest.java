package controller;

import com.lastminute.interviewtest.controller.TaxCalculatorController;
import com.lastminute.interviewtest.model.Item;
import com.lastminute.interviewtest.model.Receipt;
import com.lastminute.interviewtest.model.SoldItem;
import com.lastminute.interviewtest.model.product.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TaxCalculatorControllerTest {

    @Test
    public void getItemTest(){
        Item item = TaxCalculatorController.getItem("book","Madame Bovary","18.99","false","1");
        assertEquals(1, item.getQuantity());
        assertEquals("Madame Bovary", item.getProduct().getName());
        assertEquals(new BigDecimal("18.99"), item.getProduct().getPrice());
        assertFalse(item.getProduct().isImported());
        assertTrue(item.getProduct() instanceof Book);
    }

    @Test
    public void getItemQuantityException(){
       assertThrows(IllegalArgumentException.class, () -> TaxCalculatorController.getItem("book","Madame Bovary","18.99","false","not-numeric"));
    }

    @Test
    public void getItemPriceException(){
        assertThrows(IllegalArgumentException.class, () -> TaxCalculatorController.getItem("book","Madame Bovary","not-numeric","false","1"));
    }

    @Test
    public void getReceiptWithNoItemsTest(){
        Receipt receipt = TaxCalculatorController.getReceipt(null);
        assertNotNull(receipt);
        assertEquals(BigDecimal.ZERO, receipt.getTotal());
        assertEquals(BigDecimal.ZERO, receipt.getSalesTaxes());
    }

    @Test
    public void getReceiptWithItems(){
        List<Item> items = new ArrayList<>();
        items.add(TaxCalculatorController.getItem("book","Madame Bovary","18.99","false","2"));
        items.add(TaxCalculatorController.getItem("other","Imported smartphone","199.99","true","1"));
        items.add(TaxCalculatorController.getItem("food","Bread","0.99","false","3"));
        items.add(TaxCalculatorController.getItem("medicinal","Pills","19.99","true","1"));
        Receipt receipt = TaxCalculatorController.getReceipt(items);
        assertNotNull(receipt);
        SoldItem book = receipt.getItems().get(0);
        assertEquals(2, book.getQuantity());
        assertEquals(new BigDecimal("18.99"), book.getFinalPrice());
        assertEquals("Madame Bovary", book.getName());
        SoldItem smartphone = receipt.getItems().get(1);
        assertEquals(1, smartphone.getQuantity());
        assertEquals(new BigDecimal("229.99"), smartphone.getFinalPrice());
        assertEquals("Imported smartphone", smartphone.getName());
        SoldItem bread = receipt.getItems().get(2);
        assertEquals(3, bread.getQuantity());
        assertEquals(new BigDecimal("0.99"), bread.getFinalPrice());
        assertEquals("Bread", bread.getName());
        SoldItem pills = receipt.getItems().get(3);
        assertEquals(1, pills.getQuantity());
        assertEquals(new BigDecimal("20.99"), pills.getFinalPrice());
        assertEquals("Pills", pills.getName());
        assertEquals(new BigDecimal("31.00"), receipt.getSalesTaxes());
        assertEquals(new BigDecimal("291.93"), receipt.getTotal());
    }
}
