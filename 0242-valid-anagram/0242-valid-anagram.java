import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {
        // Check if the lengths of the two strings are equal
        if (s.length() != t.length()) {
            return false;
        }
        
        // Convert the strings to character arrays and sort them
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        
        // Compare the sorted character arrays
        return Arrays.equals(sChars, tChars);
    }
}
