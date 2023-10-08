import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String str : strs) {
            int[] charCount = new int[26];
            for (char c : str.toCharArray()) {
                charCount[c - 'a']++;
            }

            StringBuilder sortedStr = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (charCount[i] > 0) {
                    sortedStr.append((char) ('a' + i)).append(charCount[i]);
                }
            }

            String key = sortedStr.toString();

            if (!anagramGroups.containsKey(key)) {
                anagramGroups.put(key, new ArrayList<>());
            }

            anagramGroups.get(key).add(str);
        }

        return new ArrayList<>(anagramGroups.values());
    }
}
