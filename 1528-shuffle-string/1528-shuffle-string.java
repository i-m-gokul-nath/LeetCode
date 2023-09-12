class Solution {
    public String restoreString(String s, int[] indices) {
        int n = s.length();
        char[] shuffled = new char[n];
        
        // Place each character at its corresponding index
        for (int i = 0; i < n; i++) {
            shuffled[indices[i]] = s.charAt(i);
        }
        
        // Convert the character array to a string
        return new String(shuffled);
    }
}
