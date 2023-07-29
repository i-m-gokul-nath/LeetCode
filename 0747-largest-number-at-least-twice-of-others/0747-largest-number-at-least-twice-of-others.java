class Solution {
    public int dominantIndex(int[] nums) {
        int maxIdx = 0;
        int maxVal = nums[0];
        int secondMaxVal = Integer.MIN_VALUE;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > maxVal) {
                secondMaxVal = maxVal;
                maxVal = nums[i];
                maxIdx = i;
            } else if (nums[i] > secondMaxVal) {
                secondMaxVal = nums[i];
            }
        }

        return maxVal >= 2 * secondMaxVal ? maxIdx : -1;
    }
}
