import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minSteps(String s, String t) {
        
        if (s.length() != t.length()) {
            return -1; // Invalid input
        }
        
        Map<Character, Integer> freqS = new HashMap<>();
        Map<Character, Integer> freqT = new HashMap<>();

        for (char ch : s.toCharArray()) {
            freqS.put(ch, freqS.getOrDefault(ch, 0) + 1);
        }

        for (char ch : t.toCharArray()) {
            freqT.put(ch, freqT.getOrDefault(ch, 0) + 1);
        }

        int steps = 0;
        for (char ch : freqS.keySet()) {
            int countS = freqS.get(ch);
            int countT = freqT.getOrDefault(ch, 0);
            steps += Math.max(0, countS - countT);
        }

        return steps;
    }
}
