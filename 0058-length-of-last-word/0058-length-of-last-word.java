class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim(); // Remove leading and trailing spaces
        int lastSpaceIndex = s.lastIndexOf(' '); // Find the last space index
        return s.length() - lastSpaceIndex - 1; // Calculate the length of the last word
    }
}
