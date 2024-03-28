class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
         
        HashMap<Integer,Integer>map = new HashMap<>();
        
        int start=0;
        int ans=0;
        for(int end=0;end<nums.length;end++)
        {
             int v = nums[end];
             
            map.put(v,map.getOrDefault(v,0)+1);
            
            while(map.containsKey(v) && map.get(v)>k)
            {
                int val =nums[start];
                
                if(map.get(val)==1) map.remove(val);
                else
                    map.put(val,map.getOrDefault(val,0)-1); 
                
                start++;
            }
            ans=Math.max(ans,end-start+1);
        }
        return ans;
        
        
    }
}