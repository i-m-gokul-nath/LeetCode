class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) {
            return 0;
        }
        
        int totalDuration = duration; // Initialize with the first attack's duration
        
        for (int i = 1; i < timeSeries.length; i++) {
            // Calculate the overlap duration between the current attack and the previous one
            int overlap = Math.min(duration, timeSeries[i] - timeSeries[i - 1]);
            totalDuration += overlap;
        }
        
        return totalDuration;
    }
}
