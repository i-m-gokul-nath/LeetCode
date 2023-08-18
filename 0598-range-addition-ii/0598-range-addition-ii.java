class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int minAi = m;
        int minBi = n;
        
        for (int[] op : ops) {
            minAi = Math.min(minAi, op[0]);
            minBi = Math.min(minBi, op[1]);
        }
        
        return minAi * minBi;
    }
}
