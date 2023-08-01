import java.util.HashMap;

class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        // Count the frequency of each character in the string
        for (char ch : s.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        // Find the first non-repeating character
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (frequencyMap.get(ch) == 1) {
                return i;
            }
        }

        return -1;
    }
}
