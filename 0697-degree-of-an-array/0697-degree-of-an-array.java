import java.util.HashMap;

class Solution {
    public int findShortestSubArray(int[] nums) {
        // Step 1: Find the degree of the array
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        int maxFrequency = 0;
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            maxFrequency = Math.max(maxFrequency, frequencyMap.get(num));
        }
        
        // Step 2: Find the shortest subarray with the same degree
        HashMap<Integer, Integer> currentFrequencyMap = new HashMap<>();
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            int num = nums[right];
            currentFrequencyMap.put(num, currentFrequencyMap.getOrDefault(num, 0) + 1);
            
            while (currentFrequencyMap.get(num) == maxFrequency) {
                minLength = Math.min(minLength, right - left + 1);
                int leftNum = nums[left];
                currentFrequencyMap.put(leftNum, currentFrequencyMap.get(leftNum) - 1);
                left++;
            }
        }
        
        // Step 3: Return the result
        return minLength;
    }
}
