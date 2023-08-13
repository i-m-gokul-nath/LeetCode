class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        int left = 0;
        int right = n - 1;
        
        for (int i = n - 1; i >= 0; i--) {
            int squareLeft = nums[left] * nums[left];
            int squareRight = nums[right] * nums[right];
            
            if (squareLeft > squareRight) {
                result[i] = squareLeft;
                left++;
            } else {
                result[i] = squareRight;
                right--;
            }
        }
        
        return result;
    }
}
