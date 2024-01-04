import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minOperations(int[] nums) {

        Map<Integer, Integer> mp = new HashMap<>();

        for (int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            int t = entry.getValue();
            if (t == 1)
                return -1;
            
            count += t / 3; // Count the complete sets of 3 elements
            if (t % 3 != 0) // If there are remaining elements, increment the count
                count++;
        }
        return count;
    }
}