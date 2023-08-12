class Solution {
    public boolean checkRecord(String s) {
        int absentCount = 0;
        int lateCount = 0;
        
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                absentCount++;
                lateCount = 0; // Reset consecutive late days when absent
            } else if (c == 'L') {
                lateCount++;
            } else {
                lateCount = 0; // Reset consecutive late days
            }
            
            if (absentCount >= 2 || lateCount >= 3) {
                return false;
            }
        }
        
        return true;
    }
}
