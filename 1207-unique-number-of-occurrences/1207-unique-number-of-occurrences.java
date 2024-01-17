import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Count the occurrences of each element
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Check if the number of occurrences is unique using a HashSet
        HashSet<Integer> occurrencesSet = new HashSet<>(frequencyMap.values());

        // If the size of the set is equal to the size of the map, then occurrences are unique
        return occurrencesSet.size() == frequencyMap.size();
    }
}
