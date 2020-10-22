package com.lastminute.interviewtest.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileUtils {

    private static final String DELIMITER = ",";

    public static List<List<String>> readFromCsv(String fileName) throws IOException {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/"+fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(DELIMITER);
                records.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            throw e;
        }
        return records;
    }
}
