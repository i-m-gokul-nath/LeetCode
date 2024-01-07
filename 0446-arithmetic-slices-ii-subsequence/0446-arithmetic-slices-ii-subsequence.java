class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int count = 0;
        Map<Long, Integer>[] dp = new Map[n];
        
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long diff = (long)nums[i] - nums[j];
                int prevCount = dp[j].getOrDefault(diff, 0);
                count += prevCount;
                dp[i].put(diff, dp[i].getOrDefault(diff, 0) + prevCount + 1);
            }
        }
        
        return count;
    }
}