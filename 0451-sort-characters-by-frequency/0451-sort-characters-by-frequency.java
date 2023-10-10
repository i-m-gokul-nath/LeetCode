import java.util.*;

class Solution {
    public String frequencySort(String s) {
        // Count the frequency of each character and find the maximum frequency
        int maxFrequency = 0;
        int[] charFrequency = new int[256]; // Assuming extended ASCII characters
        
        for (char c : s.toCharArray()) {
            charFrequency[c]++;
            maxFrequency = Math.max(maxFrequency, charFrequency[c]);
        }

        // Create an array of lists to store characters by frequency
        List<Character>[] buckets = new ArrayList[maxFrequency + 1];
        for (int i = 0; i <= maxFrequency; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Place characters in the corresponding frequency bucket
        for (int i = 0; i < 256; i++) {
            if (charFrequency[i] > 0) {
                buckets[charFrequency[i]].add((char) i);
            }
        }

        // Build the result string by iterating over buckets in reverse order
        StringBuilder result = new StringBuilder();
        for (int i = maxFrequency; i >= 1; i--) {
            for (char c : buckets[i]) {
                for (int j = 0; j < i; j++) {
                    result.append(c);
                }
            }
        }

        return result.toString();
    }
}
