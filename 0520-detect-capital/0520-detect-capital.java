class Solution {
    public boolean detectCapitalUse(String word) {
        int uppercaseCount = 0;
        int lowercaseCount = 0;
        
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                uppercaseCount++;
            } else {
                lowercaseCount++;
            }
        }
        
        // Check the conditions
        if (uppercaseCount == word.length() || lowercaseCount == word.length() || (uppercaseCount == 1 && Character.isUpperCase(word.charAt(0)))) {
            return true;
        }
        
        return false;
    }
}
