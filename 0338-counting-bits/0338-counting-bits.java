class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // To count the number of 1's in i, you can use the formula:
            // result[i] = result[i >> 1] + (i & 1);
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }
}
