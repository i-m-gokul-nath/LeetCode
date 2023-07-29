import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        int longestPalindromeLength = 0;
        boolean hasOddFrequency = false;

        for (int count : frequencyMap.values()) {
            if (count % 2 == 0) {
                longestPalindromeLength += count;
            } else {
                longestPalindromeLength += count - 1;
                hasOddFrequency = true;
            }
        }

        return hasOddFrequency ? longestPalindromeLength + 1 : longestPalindromeLength;
    }
}
