class Solution {
    public long largestPerimeter(int[] nums) {
        int len=nums.length;
        Arrays.sort(nums);
        long arr[]=new long[len];
        arr[0]=nums[0];
        for(int i=1;i<len;i++)
        {
            arr[i]+=arr[i-1]+nums[i];
        }
        long ans=Integer.MIN_VALUE;
        for(int i=2;i<len;i++)
        {
            if(arr[i]-arr[i-1] < arr[i-1])
            {
                ans=Math.max(ans,arr[i]);
            }
        }
        return ans ==Integer.MIN_VALUE ? -1 : ans;
    }
}