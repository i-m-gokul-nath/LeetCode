import java.util.*;

class Solution {
    public String frequencySort(String s) {
        // Count the frequency of each character using a HashMap
        Map<Character, Integer> charFrequency = new HashMap<>();
        for (char c : s.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }

        // Create a list of characters sorted by frequency in decreasing order
        List<Character> sortedChars = new ArrayList<>(charFrequency.keySet());
        sortedChars.sort((a, b) -> charFrequency.get(b) - charFrequency.get(a));

        // Build the result string based on the sorted characters and their frequency
        StringBuilder result = new StringBuilder();
        for (char c : sortedChars) {
            int frequency = charFrequency.get(c);
            for (int i = 0; i < frequency; i++) {
                result.append(c);
            }
        }

        return result.toString();
    }
}
