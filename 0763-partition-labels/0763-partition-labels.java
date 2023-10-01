import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int[] lastOccurrence = new int[26];

        // Record the last occurrence index of each character.
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            end = Math.max(end, lastOccurrence[currentChar - 'a']);

            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }

        return result;
    }
}
