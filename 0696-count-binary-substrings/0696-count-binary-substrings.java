class Solution {
    public int countBinarySubstrings(String s) {
        int count = 0;
        int prevCount = 0;
        int currentCount = 1; // Initialize current count to 1 as the string is non-empty
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currentCount++;
            } else {
                prevCount = currentCount;
                currentCount = 1;
            }
            
            if (prevCount >= currentCount) {
                count++;
            }
        }
        
        return count;
    }
}
