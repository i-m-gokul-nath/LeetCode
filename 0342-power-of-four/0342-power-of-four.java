class Solution {
    public boolean isPowerOfFour(int n) {
        // Check if n is positive and a power of two
        return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }
}
