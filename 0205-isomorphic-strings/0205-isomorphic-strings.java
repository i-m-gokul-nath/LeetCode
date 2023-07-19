import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        Map<Character, Character> sToT = new HashMap<>();
        Map<Character, Character> tToS = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            
            if (sToT.containsKey(sChar) && sToT.get(sChar) != tChar) {
                return false;
            }
            
            if (tToS.containsKey(tChar) && tToS.get(tChar) != sChar) {
                return false;
            }
            
            sToT.put(sChar, tChar);
            tToS.put(tChar, sChar);
        }
        
        return true;
    }
}
