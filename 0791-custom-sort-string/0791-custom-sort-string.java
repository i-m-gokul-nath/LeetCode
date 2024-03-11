import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String customSortString(String order, String s) {
        int[] customOrder = new int[26];
        Arrays.fill(customOrder, -1);

        for (int i = 0; i < order.length(); i++) {
            customOrder[order.charAt(i) - 'a'] = i;
        }

        Comparator<Character> comparator = (a, b) -> Integer.compare(customOrder[a - 'a'], customOrder[b - 'a']);

        Character[] sArray = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            sArray[i] = s.charAt(i);
        }
        Arrays.sort(sArray, comparator);

        StringBuilder result = new StringBuilder();
        for (char c : sArray) {
            result.append(c);
        }
        return result.toString();
    }
}