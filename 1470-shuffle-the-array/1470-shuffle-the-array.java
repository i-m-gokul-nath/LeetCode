class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        
        for (int i = 0; i < n; i++) {
            result[2 * i] = nums[i];          // Place elements from the first half
            result[2 * i + 1] = nums[n + i];  // Place elements from the second half
        }
        
        return result;
    }
}
