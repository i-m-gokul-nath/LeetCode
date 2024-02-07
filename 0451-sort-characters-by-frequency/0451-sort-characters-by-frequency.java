import java.util.*;

class Solution {
    public String frequencySort(String s) {

        Map<Character, Integer> charFrequency = new HashMap<>();
        for (char c : s.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }

        List<Character> charList = new ArrayList<>(charFrequency.keySet());
        charList.sort((a, b) -> charFrequency.get(b) - charFrequency.get(a));

        StringBuilder result = new StringBuilder();
        for (char c : charList) {
            int frequency = charFrequency.get(c);
            for (int i = 0; i < frequency; i++) {
                result.append(c);
            }
        }

        return result.toString();
    }
}
