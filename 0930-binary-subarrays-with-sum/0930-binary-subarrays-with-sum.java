import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> sumCount = new HashMap<>();
        int count = 0;
        int runningSum = 0;

        for (int num : nums) {
            runningSum += num;

            if (runningSum == goal) {
                count++;
            }

            int complement = runningSum - goal;
            if (sumCount.containsKey(complement)) {
                count += sumCount.get(complement);
            }

            sumCount.put(runningSum, sumCount.getOrDefault(runningSum, 0) + 1);
        }

        return count;
    }
}