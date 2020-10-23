package factory;

import com.lastminute.interviewtest.factory.ProductFactory;
import com.lastminute.interviewtest.model.product.Book;
import com.lastminute.interviewtest.model.product.Product;
import model.Beverage;
import org.junit.Test;

import java.util.function.Supplier;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class ProductFactoryTest {

    @Test
    public void productNotRegisteredException(){
        assertThrows(IllegalArgumentException.class, () -> ProductFactory.getProduct("tech"));
    }

    @Test
    public void getProductTest(){
        Product book = ProductFactory.getProduct("book");
        assertTrue(book instanceof Book);
    }

    @Test
    public void registerNewProductTest(){
        ProductFactory.registerProduct("beverage", new Supplier<Product>() {
            @Override
            public Product get() {
                return new Beverage();
            }
        });
    }
}
