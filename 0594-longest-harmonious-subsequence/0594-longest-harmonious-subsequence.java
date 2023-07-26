import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int maxLength = 0;
        
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            
            int currLength = frequencyMap.get(num);
            int prevLength = frequencyMap.getOrDefault(num - 1, 0);
            int nextLength = frequencyMap.getOrDefault(num + 1, 0);
            
            if (prevLength > 0) {
                maxLength = Math.max(maxLength, currLength + prevLength);
            }
            
            if (nextLength > 0) {
                maxLength = Math.max(maxLength, currLength + nextLength);
            }
        }
        
        return maxLength;
    }
}
