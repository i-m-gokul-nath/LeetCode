import java.util.*;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] minutes = new boolean[24 * 60]; // to mark whether each minute is visited
        int minTime = 24 * 60; // maximum possible time

        for (String time : timePoints) {
            int minutesOfDay = convertToMinutes(time);
            if (minutes[minutesOfDay]) return 0; // there's at least one duplicate
            minutes[minutesOfDay] = true;
        }

        int prev = 0, first = Integer.MAX_VALUE, last = Integer.MIN_VALUE;

        for (int i = 0; i < 24 * 60; i++) {
            if (minutes[i]) {
                if (first != Integer.MAX_VALUE) {
                    minTime = Math.min(minTime, i - prev);
                }
                first = Math.min(first, i);
                last = Math.max(last, i);
                prev = i;
            }
        }

        // Consider the circular property of the 24-hour clock
        int circular = 24 * 60 - (last - first);
        return Math.min(minTime, circular);
    }

    private int convertToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
}
