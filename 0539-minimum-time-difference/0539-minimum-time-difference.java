import java.util.List;
import java.util.Collections;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        List<Integer> minutes = new ArrayList<>();
        
        for (String time : timePoints) {
            int minutesOfDay = convertToMinutes(time);
            minutes.add(minutesOfDay);
        }
        
        Collections.sort(minutes);
        
        int minDiff = Integer.MAX_VALUE;
        
        for (int i = 1; i < n; i++) {
            minDiff = Math.min(minDiff, minutes.get(i) - minutes.get(i - 1));
        }
        
        // Consider the circular property of the 24-hour clock
        int lastToFirst = 24 * 60 - minutes.get(n - 1) + minutes.get(0);
        minDiff = Math.min(minDiff, lastToFirst);
        
        return minDiff;
    }

    private int convertToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
}
