import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        // Sort the balloons based on their ending points
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;  // Initialize with 1 arrow
        int end = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                // Need a new arrow because the current arrow won't hit this balloon
                arrows++;
                end = points[i][1];
            }
            // Otherwise, the arrow can still hit this balloon
        }

        return arrows;
    }
}
