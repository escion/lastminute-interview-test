package com.lastminute.interviewtest;

import com.lastminute.interviewtest.factory.ProductFactory;
import com.lastminute.interviewtest.model.Item;
import com.lastminute.interviewtest.model.Receipt;
import com.lastminute.interviewtest.model.product.Product;
import com.lastminute.interviewtest.service.TaxCalculatorService;
import com.lastminute.interviewtest.utils.FileUtils;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReceiptApplication {

    private final static Logger log = Logger.getLogger(FileUtils.class.getName());
    static List<Integer> FILE_INDEXES = Arrays.asList(1,2,3);

    public static void main(String[] args){
        FILE_INDEXES.forEach(i -> {
            List<List<String>> csv = null;
            try {
                csv = FileUtils.readFromCsv("input_" + i + ".csv");
            } catch (IOException e) {
                log.log(Level.SEVERE, "Could not open file csv", e);
            }
            List<Item> items = new ArrayList<>();
            csv.forEach(row -> {
                Product product = ProductFactory.getProduct(row.get(1), row.get(2), new BigDecimal(row.get(3)), Boolean.valueOf(row.get(4)));
                items.add(new Item(Integer.valueOf(row.get(0)), product));
            });
            Receipt receipt = TaxCalculatorService.getReceipt(items);
            printData(receipt);
        });
    }

    private static void printData(Receipt receipt){
        receipt.getItems().forEach(item -> System.out.println(item.getQuantity() + " " + item.getName() + ": " + item.getPrice()));
        System.out.println("Sales taxes: " + receipt.getSalesTaxes());
        System.out.println("Total: " + receipt.getTotal()+"\n");
    }
}
