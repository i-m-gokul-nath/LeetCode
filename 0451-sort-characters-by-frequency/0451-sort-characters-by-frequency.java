import java.util.*;

class Solution {
    public String frequencySort(String s) {
        // Count the frequency of each character using a HashMap
        Map<Character, Integer> charFrequency = new HashMap<>();
        for (char c : s.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }

        // Create a max-heap (priority queue) based on character frequency
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> charFrequency.get(b) - charFrequency.get(a));

        // Add all characters to the max-heap
        maxHeap.addAll(charFrequency.keySet());

        // Build the result string based on the max-heap
        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char c = maxHeap.poll();
            int frequency = charFrequency.get(c);
            for (int i = 0; i < frequency; i++) {
                result.append(c);
            }
        }

        return result.toString();
    }
}
