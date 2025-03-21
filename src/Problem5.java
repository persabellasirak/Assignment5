import java.util.*;

public class Problem5 {
    public static void radixSortStrings(String[] arr) {
        if (arr.length == 0) return;

        // First, sort by length to prioritize shorter words (important for lexicographical order)
        Arrays.sort(arr, Comparator.comparingInt(String::length));

        int maxLength = Arrays.stream(arr).mapToInt(String::length).max().orElse(0);

        for (int pos = maxLength - 1; pos >= 0; pos--) {
            TreeMap<Character, List<String>> buckets = new TreeMap<>();

            // Use a special character for shorter words (lower than 'a')
            char specialChar = ' ';

            for (char c = 'A'; c <= 'Z'; c++) buckets.put(c, new ArrayList<>());
            for (char c = 'a'; c <= 'z'; c++) buckets.put(c, new ArrayList<>());
            buckets.put(specialChar, new ArrayList<>()); // Shorter words

            for (String word : arr) {
                char key = pos < word.length() ? word.charAt(pos) : specialChar;
                buckets.get(key).add(word);
            }

            int index = 0;
            for (char c : buckets.keySet()) {
                for (String word : buckets.get(c)) {
                    arr[index++] = word;
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] words = {"google", "gojo", "amazingly", "jogo", "luna", "pup", "solas", "solo", "pupperino",
                "amaterasu", "amazon", "puppy", "hydra", "amazonia", "vueltiao"};

        radixSortStrings(words);

        System.out.println(String.join(", ", words));
    }
}
