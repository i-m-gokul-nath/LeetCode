public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            // Shift the result to the left by 1 bit
            result <<= 1;
            // Check if the least significant bit of n is 1
            if ((n & 1) == 1) {
                // Set the least significant bit of the result to 1
                result |= 1;
            }
            // Shift n to the right by 1 bit
            n >>= 1;
        }
        return result;
    }
}
