class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] count = new int[101]; // As per the constraint, 0 <= nums[i] <= 100
        
        // Count the frequency of each number in nums
        for (int num : nums) {
            count[num]++;
        }
        
        // Calculate the count of numbers smaller than each element in nums
        for (int i = 1; i <= 100; i++) {
            count[i] += count[i - 1];
        }
        
        // Fill the result array
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                result[i] = 0; // Special case for 0
            } else {
                result[i] = count[nums[i] - 1];
            }
        }
        
        return result;
    }
}
