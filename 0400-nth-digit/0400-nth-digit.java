class Solution {
    public int findNthDigit(int n) {
        
        int digits = 1;
        long count = 9;
        int start = 1;

        while (n > digits * count) {
            n -= digits * count;
            digits++;
            count *= 10;
            start *= 10;
        }

        int num = start + (n - 1) / digits;

        int position = (n - 1) % digits;

        return String.valueOf(num).charAt(position) - '0';
    }
}