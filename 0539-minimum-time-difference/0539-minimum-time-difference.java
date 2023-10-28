import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        // Convert time points to minutes
        List<Integer> minutes = new ArrayList<>();
        for (String time : timePoints) {
            String[] parts = time.split(":");
            int h = Integer.parseInt(parts[0]);
            int m = Integer.parseInt(parts[1]);
            minutes.add(h * 60 + m);
        }

        // Sort the minutes
        Collections.sort(minutes);

        int minDifference = Integer.MAX_VALUE;

        // Find the minimum difference between adjacent time points
        for (int i = 1; i < minutes.size(); i++) {
            int diff = minutes.get(i) - minutes.get(i - 1);
            minDifference = Math.min(minDifference, diff);
        }

        // Consider the circular property of the 24-hour clock
        int circularDifference = minutes.get(0) + (1440 - minutes.get(minutes.size() - 1));
        return Math.min(minDifference, circularDifference);
    }
}
