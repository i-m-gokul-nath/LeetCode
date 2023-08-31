class Solution {
    public String longestNiceSubstring(String s) {
        int n = s.length();
        String result = "";

        for (int i = 0; i < n; i++) {
            int lowerMask = 0, upperMask = 0;
            
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                
                if (c >= 'a' && c <= 'z') {
                    lowerMask |= (1 << (c - 'a'));
                } else {
                    upperMask |= (1 << (c - 'A'));
                }
                
                if (lowerMask == upperMask) {
                    if (j - i + 1 > result.length()) {
                        result = s.substring(i, j + 1);
                    }
                }
            }
        }

        return result;
    }
}
