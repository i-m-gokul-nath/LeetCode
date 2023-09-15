class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        boolean[] isJewel = new boolean[128]; // Assuming ASCII characters
        
        for (char jewel : jewels.toCharArray()) {
            isJewel[jewel] = true;
        }
        
        for (char stone : stones.toCharArray()) {
            if (isJewel[stone]) {
                count++;
            }
        }
        
        return count;
    }
}
