import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        int minIndexSum = Integer.MAX_VALUE;
        
        // Populate the map with words from list1 and their indices
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        
        // Check each word in list2
        for (int j = 0; j < list2.length; j++) {
            String word = list2[j];
            
            // If the word is present in list1
            if (map.containsKey(word)) {
                int indexSum = j + map.get(word);
                
                // If the index sum is smaller than the current minimum index sum
                if (indexSum < minIndexSum) {
                    // Update the minimum index sum
                    minIndexSum = indexSum;
                    
                    // Clear the result list and add the current word
                    result.clear();
                    result.add(word);
                } else if (indexSum == minIndexSum) {
                    // If the index sum is equal to the current minimum index sum
                    // Add the current word to the result list
                    result.add(word);
                }
            }
        }
        
        return result.toArray(new String[0]);
    }
}
