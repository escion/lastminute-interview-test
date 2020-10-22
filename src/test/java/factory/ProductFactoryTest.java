package factory;

import com.lastminute.interviewtest.factory.ProductFactory;
import com.lastminute.interviewtest.model.product.Book;
import com.lastminute.interviewtest.model.product.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ProductFactoryTest {

    @Test
    public void productNotRegisteredException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> ProductFactory.getProduct("beverage","Coke",new BigDecimal("5.99"), false));
    }

    @Test
    public void getProductTest(){
        Product book = ProductFactory.getProduct("book","Madame Bovary",new BigDecimal("4.55"),false);
        Assertions.assertTrue(book instanceof Book);
    }
}
