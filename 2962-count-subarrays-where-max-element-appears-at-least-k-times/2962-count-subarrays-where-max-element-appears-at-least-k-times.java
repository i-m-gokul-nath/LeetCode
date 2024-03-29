class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int maxE = Arrays.stream(nums).max().getAsInt();
        int count = 0;
        long result = 0;

        int i = 0, j = 0;

        while(j < n){
            if(nums[j] == maxE){
                count++;
            }
            while(count >= k){
                result += n-j;

                if(nums[i]==maxE){
                    count--;
                } 
                i++;
            }
            j++;
        }
        return result;
    }
}