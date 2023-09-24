class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length / 2;
        
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        
        return -1; // This line should not be reached given the constraints.
    }
}
