class Solution {
    public boolean isPowerOfThree(int n) {
        // Loop or Recursion Approach
        if (n <= 0) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
        
    }
}
