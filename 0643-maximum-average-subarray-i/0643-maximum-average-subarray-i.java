class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double maxAverage = (double) sum / k;

        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxAverage = Math.max(maxAverage, (double) sum / k);
        }

        return maxAverage;
    }
}
