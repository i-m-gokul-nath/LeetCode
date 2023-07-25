class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // Check if any of the conditions for non-overlap is true
        if (rec1[2] <= rec2[0] || // rec1 is to the left of rec2
            rec1[0] >= rec2[2] || // rec1 is to the right of rec2
            rec1[1] >= rec2[3] || // rec1 is above rec2
            rec1[3] <= rec2[1]) { // rec1 is below rec2
            return false;
        }
        // If none of the conditions are true, then the rectangles overlap
        return true;
    }
}
