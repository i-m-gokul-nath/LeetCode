class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        
        do {
            slow = getSquareSum(slow);
            fast = getSquareSum(getSquareSum(fast));
        } while (slow != 1 && slow != fast);
        
        return slow == 1;
    }
    
    private int getSquareSum(int n) {
        int sum = 0;
        
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        
        return sum;
    }
}
