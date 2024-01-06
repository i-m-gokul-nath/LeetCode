import java.util.Arrays;
import java.util.TreeMap;

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        
        TreeMap<Integer, Integer> dp = new TreeMap<>();
        dp.put(0, 0); 
        
        for (int[] job : jobs) {
            int prevMaxProfit = dp.floorEntry(job[0]).getValue();

            int totalProfit = prevMaxProfit + job[2];

            int maxProfit = dp.lastEntry().getValue();
            if (totalProfit > maxProfit) {
                dp.put(job[1], totalProfit);
            }
        }
        
        return dp.lastEntry().getValue();
    }
}