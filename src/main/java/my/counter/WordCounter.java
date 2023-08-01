package my.counter;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {
    public static int countWordOccurrences(String text, String word) {
        Pattern pattern = Pattern.compile("\\b" + word + "\\b");
        Matcher matcher = pattern.matcher(text);
        int count = 0;

        while (matcher.find()) {
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        String text = "Imperative programming is divided into three broad categories: Procedural programming paradigm, Object-oriented programming, and the Parallel processing approach. Let's talk about them in more detail.";
        String wordToCount = "programming";
        int occurrences = countWordOccurrences(text, wordToCount);
        System.out.println();
        System.out.println("The word '" + wordToCount + "' appears " + occurrences + " times in the text.");
    }
}