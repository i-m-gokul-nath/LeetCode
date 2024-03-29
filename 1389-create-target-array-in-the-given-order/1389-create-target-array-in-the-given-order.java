class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int n = nums.length;
        int[] target = new int[n];
        
        for (int i = 0; i < n; i++) {
            int idx = index[i];
            int num = nums[i];
            
            // Shift elements to the right to make space for the new element
            System.arraycopy(target, idx, target, idx + 1, n - idx - 1);
            
            // Insert the element at the specified index
            target[idx] = num;
        }
        
        return target;
    }
}
