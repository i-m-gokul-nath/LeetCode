class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int n = nums.length;
        int[] target = new int[n];
        
        for (int i = 0; i < n; i++) {
            int idx = index[i];
            int num = nums[i];
            
            // Shift elements to the right to make space for the new element
            for (int j = n - 1; j > idx; j--) {
                target[j] = target[j - 1];
            }
            
            // Insert the element at the specified index
            target[idx] = num;
        }
        
        return target;
    }
}
