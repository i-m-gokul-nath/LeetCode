class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] charCount = new int[26]; // To store the count of each character in magazine
        
        // Count the occurrences of each character in magazine
        for (char c : magazine.toCharArray()) {
            charCount[c - 'a']++;
        }
        
        // Check if the characters in ransomNote can be constructed from magazine
        for (char c : ransomNote.toCharArray()) {
            if (charCount[c - 'a'] == 0) {
                return false; // Character not available in magazine
            }
            charCount[c - 'a']--; // Use the character from magazine
        }
        
        return true; // All characters in ransomNote can be constructed from magazine
    }
}
