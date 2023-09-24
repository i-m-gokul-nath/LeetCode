import java.util.HashMap;
import java.util.Map;

class Solution {
    public int repeatedNTimes(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            
            if (frequencyMap.get(num) == nums.length / 2) {
                return num;
            }
        }
        
        return -1; // This line should not be reached given the constraints.
    }
}
