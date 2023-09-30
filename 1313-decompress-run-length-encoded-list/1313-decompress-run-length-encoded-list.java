class Solution {
    public int[] decompressRLElist(int[] nums) {
        int totalLength = 0;
        for (int i = 0; i < nums.length; i += 2) {
            totalLength += nums[i];
        }
        
        int[] result = new int[totalLength];
        int index = 0;
        
        for (int i = 0; i < nums.length; i += 2) {
            int freq = nums[i];
            int val = nums[i + 1];
            
            // Fill the result array with val 'freq' times
            Arrays.fill(result, index, index + freq, val);
            index += freq;
        }
        
        return result;
    }
}
