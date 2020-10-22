package utils;

import com.lastminute.interviewtest.utils.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class FileUtilsTest {

    @Test
    public void readFromCsvTest() throws IOException {
        List<List<String>> records = FileUtils.readFromCsv("input_1.csv");
        Assertions.assertNotNull(records);
        Assertions.assertEquals(3, records.size());
        records = FileUtils.readFromCsv("input_2.csv");
        Assertions.assertNotNull(records);
        Assertions.assertEquals(2, records.size());
        records = FileUtils.readFromCsv("input_3.csv");
        Assertions.assertNotNull(records);
        Assertions.assertEquals(4, records.size());
    }

    @Test
    public void readFromCsvExceptionTest(){
        Assertions.assertThrows(IOException.class, () -> FileUtils.readFromCsv("fake.csv"));
    }
}
