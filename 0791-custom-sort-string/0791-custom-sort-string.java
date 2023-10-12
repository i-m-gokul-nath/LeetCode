class Solution {
    public String customSortString(String order, String s) {
        // Create a character frequency array for string s.
        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }
        
        StringBuilder result = new StringBuilder();
        
        // Append characters from order to the result string.
        for (char c : order.toCharArray()) {
            while (charCount[c - 'a'] > 0) {
                result.append(c);
                charCount[c - 'a']--;
            }
        }
        
        // Append remaining characters from s to the result string.
        for (char c = 'a'; c <= 'z'; c++) {
            while (charCount[c - 'a'] > 0) {
                result.append(c);
                charCount[c - 'a']--;
            }
        }
        
        return result.toString();
    }
}
