import java.util.LinkedList;

class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int n = nums.length;
        LinkedList<Integer> target = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            int idx = index[i];
            int num = nums[i];
            
            // Insert the element at the specified index
            target.add(idx, num);
        }
        
        // Convert the LinkedList to an array
        int[] result = new int[n];
        int i = 0;
        for (int num : target) {
            result[i++] = num;
        }
        
        return result;
    }
}
