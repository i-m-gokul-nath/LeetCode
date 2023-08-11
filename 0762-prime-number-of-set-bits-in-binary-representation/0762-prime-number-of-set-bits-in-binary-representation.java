class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        boolean[] primes = new boolean[33];
        primes[2] = primes[3] = primes[5] = primes[7] = primes[11] = primes[13] = primes[17] = primes[19] = primes[23] = primes[29] = primes[31] = true;

        for (int num = left; num <= right; num++) {
            if (primes[countSetBits(num)]) {
                count++;
            }
        }

        return count;
    }

    private int countSetBits(int num) {
        int count = 0;
        while (num > 0) {
            num &= (num - 1);
            count++;
        }
        return count;
    }
}
