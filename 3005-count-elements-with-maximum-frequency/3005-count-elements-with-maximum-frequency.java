class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                hm.put(nums[i],hm.get(nums[i])+1);
            }
            else{
                hm.put(nums[i],1);
            }
        }
       
        int max=0,time=1;
        for(Integer i:hm.keySet()){
            if(hm.get(i)>max){
                max=hm.get(i);
                time=1;
            }
            else if(hm.get(i)==max){
                time++;
            }
        }
        return max*time;
    }
}