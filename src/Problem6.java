import java.util.*;
import java.util.regex.Pattern;

public class Problem6 {
    public static boolean doesPatternMatch(String pattern, char delimiter, String s) {
        // Escape the delimiter if it is a special regex character
        String[] words = s.split(Pattern.quote(String.valueOf(delimiter))); // Split the string by the delimiter

        if (pattern.length() != words.length) {
            return false; // Pattern length must match the number of words
        }

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(word)) {
                    return false; // Character must map to the same word
                }
            } else {
                charToWord.put(c, word);
            }

            if (wordToChar.containsKey(word)) {
                if (wordToChar.get(word) != c) {
                    return false; // Word must map to the same character
                }
            } else {
                wordToChar.put(word, c);
            }
        }

        return true; // If all mappings are consistent, return true
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(doesPatternMatch("abba", '?', "dog?cat?cat?dog")); // true
        System.out.println(doesPatternMatch("abba", '|', "apple|banana|grape|apple")); // false
        System.out.println(doesPatternMatch("aaaa", ',', "dog,cat,cat,dog")); // false
        System.out.println(doesPatternMatch("aaaa", ' ', "ice cream taco day")); // false
        System.out.println(doesPatternMatch("adxp", ' ', "ice cream taco day")); // true
    }
}
