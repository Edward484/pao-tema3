package test.java;

import main.java.ro.unibuc.FileWordCounter;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileWordCounterTest {

    FileWordCounter counter = new FileWordCounter();

    @Test
    void testWordCountSize1() {
        List<String> strings = counter.getSizeOne("src/test/resources/poezie1.txt");

        assertEquals(5, strings.size());
    }

    @Test
    void testWordCountSizeLessThan3() {
        List<String> strings = counter.getSizeLessThan3("src/test/resources/poezie1.txt" );

        assertEquals(23, strings.size());
    }

    @Test
    void testWordCountCaptain() {
        //atentie la cele care contin si un "!" dupa Captain
        List<String> strings = counter.countWordAppearances("src/test/resources/poezie2.txt", "Captain");

        assertEquals(7, strings.size());
    }
}
