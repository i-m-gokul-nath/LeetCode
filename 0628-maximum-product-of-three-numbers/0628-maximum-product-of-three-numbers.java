import java.util.Arrays;

class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        
        int scenario1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int scenario2 = nums[0] * nums[1] * nums[n - 1];
        
        return Math.max(scenario1, scenario2);
    }
}
