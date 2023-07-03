import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] findWords(String[] words) {
        List<String> result = new ArrayList<>();
        String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        
        for (String word : words) {
            if (isInOneRow(word.toLowerCase(), rows)) {
                result.add(word);
            }
        }
        
        return result.toArray(new String[0]);
    }
    
    private boolean isInOneRow(String word, String[] rows) {
        for (String row : rows) {
            boolean isInRow = true;
            for (char c : word.toCharArray()) {
                if (row.indexOf(c) == -1) {
                    isInRow = false;
                    break;
                }
            }
            if (isInRow) {
                return true;
            }
        }
        return false;
    }
}
