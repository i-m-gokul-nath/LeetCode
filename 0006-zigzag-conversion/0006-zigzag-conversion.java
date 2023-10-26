class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s; // If numRows is 1, return the original string
        
        int n = s.length();
        char[] result = new char[n];
        int cycleLen = 2 * numRows - 2;
        int index = 0;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; i + j < n; j += cycleLen) {
                result[index++] = s.charAt(i + j);
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n) {
                    result[index++] = s.charAt(j + cycleLen - i);
                }
            }
        }

        return new String(result);
    }
}
