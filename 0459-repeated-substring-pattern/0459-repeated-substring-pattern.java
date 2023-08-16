class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int[] lps = computeLPSArray(s);
        
        int longestRepeatedLength = lps[n - 1];
        int repeatedLength = n - longestRepeatedLength;
        
        return longestRepeatedLength > 0 && n % repeatedLength == 0;
    }
    
    private int[] computeLPSArray(String s) {
        int n = s.length();
        int[] lps = new int[n];
        
        int len = 0;  // Length of the previous longest prefix suffix
        
        int i = 1;
        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        return lps;
    }
}
