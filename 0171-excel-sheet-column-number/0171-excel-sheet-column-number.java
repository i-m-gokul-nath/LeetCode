class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        int n = columnTitle.length();

        for (int i = 0; i < n; i++) {
            int columnValue = columnTitle.charAt(n - i - 1) - 'A' + 1;
            result += columnValue * Math.pow(26, i);
        }

        return result;
    }
}
