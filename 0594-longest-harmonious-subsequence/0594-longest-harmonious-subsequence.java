import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        int maxLength = 0;
        for (int num : frequencyMap.keySet()) {
            if (frequencyMap.containsKey(num + 1)) {
                int harmoniousLength = frequencyMap.get(num) + frequencyMap.get(num + 1);
                maxLength = Math.max(maxLength, harmoniousLength);
            }
        }
        
        return maxLength;
    }
}
