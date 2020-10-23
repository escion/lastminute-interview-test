package com.lastminute.interviewtest;

import com.lastminute.interviewtest.controller.TaxCalculatorController;
import com.lastminute.interviewtest.model.Item;
import com.lastminute.interviewtest.model.Receipt;
import com.lastminute.interviewtest.utils.FileUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ReceiptApplication {

    private final static Logger log = Logger.getLogger(FileUtils.class.getName());
    static List<Integer> FILE_INDEXES = Arrays.asList(1,2,3);

    public static void main(String[] args){
        FILE_INDEXES.forEach(i -> {
            List<List<String>> csv = null;
            try {
                csv = FileUtils.readFromCsv("input_" + i + ".csv");
                List<Item> items = csv
                                    .stream()
                                    .map(row -> TaxCalculatorController.getItem(row.get(1), row.get(2), row.get(3), row.get(4), row.get(0)))
                                    .collect(Collectors.toList());
                Receipt receipt = TaxCalculatorController.getReceipt(items);
                printData(receipt);
            } catch (IOException e) {
                log.log(Level.SEVERE, "Could not open file csv", e);
            }
        });
    }

    private static void printData(Receipt receipt){
        receipt.getItems().forEach(item -> System.out.println(item.getQuantity() + " " + item.getName() + ": " + item.getFinalPrice()));
        System.out.println("Sales taxes: " + receipt.getSalesTaxes());
        System.out.println("Total: " + receipt.getTotal()+"\n");
    }
}
