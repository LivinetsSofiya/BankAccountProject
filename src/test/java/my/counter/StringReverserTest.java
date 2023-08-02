package my.counter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringReverserTest {

    @Test
    public void testReverseString() {

        String input1 = "hello";
        String expectedOutput1 = "olleh";
        String actualOutput1 = StringReverser.reverseString(input1);
        assertEquals(expectedOutput1, actualOutput1);
        System.out.println("Test Case 1: Input: " + input1 + ", Expected Output: " + expectedOutput1 + ", Actual Output: " + actualOutput1);


        String input2 = "hello world";
        String expectedOutput2 = "dlrow olleh";
        String actualOutput2 = StringReverser.reverseString(input2);
        assertEquals(expectedOutput2, actualOutput2);
        System.out.println("Test Case 2: Input: " + input2 + ", Expected Output: " + expectedOutput2 + ", Actual Output: " + actualOutput2);


        String input3 = "";
        String expectedOutput3 = "";
        String actualOutput3 = StringReverser.reverseString(input3);
        assertEquals(expectedOutput3, actualOutput3);
        System.out.println("Test Case 3: Input: " + input3 + ", Expected Output: " + expectedOutput3 + ", Actual Output: " + actualOutput3);
    }
}