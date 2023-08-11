class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count = 0;

        for (int num = left; num <= right; num++) {
            if (isPrime(countSetBits(num))) {
                count++;
            }
        }

        return count;
    }

    private int countSetBits(int num) {
        int count = 0;
        while (num > 0) {
            count += num & 1;
            num >>= 1;
        }
        return count;
    }

    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
