class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) {
            return false;
        }
        
        int sum = 1; // Start with 1 since every number is divisible by 1
        
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                
                // If i is not equal to num / i, then include num / i in the sum
                if (i != num / i) {
                    sum += num / i;
                }
            }
        }
        
        return sum == num;
    }
}
