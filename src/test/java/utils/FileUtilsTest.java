package utils;

import com.lastminute.interviewtest.utils.FileUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class FileUtilsTest {

    @Test
    public void readFromCsvTest() throws IOException {
        List<List<String>> records = FileUtils.readFromCsv("input_1.csv");
        assertNotNull(records);
        assertEquals(3, records.size());
        records = FileUtils.readFromCsv("input_2.csv");
        assertNotNull(records);
        assertEquals(2, records.size());
        records = FileUtils.readFromCsv("input_3.csv");
        assertNotNull(records);
        assertEquals(4, records.size());
    }

    @Test
    public void readFromCsvExceptionTest(){
        assertThrows(IOException.class, () -> FileUtils.readFromCsv("fake.csv"));
    }
}
