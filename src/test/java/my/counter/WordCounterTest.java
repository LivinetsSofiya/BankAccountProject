package my.counter;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class WordCounterTest {
    @Test
    public void testCountWordOccurrences() {
        String text = "Imperative programming is divided into three broad categories: Procedural programming paradigm, Object-oriented programming, and the Parallel processing approach. Let's talk about them in more detail.";
        String wordToCount = "programming";

        int expectedOccurrences = 3;
        int actualOccurrences = WordCounter.countWordOccurrences(text, wordToCount);

        System.out.println("Test Case: Count occurrences of word '" + wordToCount + "' in the text.");
        System.out.println("Expected: " + expectedOccurrences);
        System.out.println("Actual  : " + actualOccurrences);

        assertEquals(expectedOccurrences, actualOccurrences);
    }
}