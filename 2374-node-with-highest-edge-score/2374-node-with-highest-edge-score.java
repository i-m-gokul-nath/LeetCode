class Solution {
    public int edgeScore(int[] edges) {
        int n = edges.length;
        long[] score = new long[n];
        for(int i=0;i<n;i++){
            score[edges[i]]+=i;
        }
        long max = Integer.MIN_VALUE;
        int id = -1;
        for(int i=0;i<n;i++){
            if(score[i]>max){
                max = score[i];
                id = i;
            }
        }
        return id;
    }
}