class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostKDistinct(nums, k) - atMostKDistinct(nums, k - 1);
    }
    
    private int atMostKDistinct(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = 0;
        int count = 0;
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        while (right < n) {
            int num = nums[right];
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            right++;
            
            while (frequencyMap.size() > k) {
                int leftNum = nums[left];
                frequencyMap.put(leftNum, frequencyMap.get(leftNum) - 1);
                if (frequencyMap.get(leftNum) == 0) {
                    frequencyMap.remove(leftNum);
                }
                left++;
            }

            count += right - left;
        }
        
        return count;
    }
}
