class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count = 0;
        int left = 0;
        int right = 0;
        long minIndex = -1;
        long maxIndex = -1;
        
        while (right < nums.length) {
            if (nums[right] >= minK && nums[right] <= maxK) {
                if (nums[right] == minK) minIndex = right;

                if (nums[right] == maxK) maxIndex = right;

                if (minIndex != -1 && maxIndex != -1) count += Math.min(minIndex, maxIndex) - left + 1;
            } else {
                left = right + 1;
                minIndex = -1;
                maxIndex = -1;
            }

            right++;
        }

        return count;
    }
}