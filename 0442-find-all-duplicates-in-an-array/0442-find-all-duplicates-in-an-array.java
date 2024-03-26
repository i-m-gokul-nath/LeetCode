class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        
        for (int num : nums) {
            int index = Math.abs(num) - 1; 
            if (nums[index] < 0) {
                duplicates.add(Math.abs(num));
            } else {
                nums[index] = -nums[index]; 
            }
        }
        
        return duplicates;
    }
}