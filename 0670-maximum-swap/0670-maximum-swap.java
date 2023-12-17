class Solution {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        int[] lastPosition = new int[10]; 
        
        for (int i = 0; i < digits.length; i++) {
            lastPosition[digits[i] - '0'] = i;
        }

        for (int i = 0; i < digits.length; i++) {

            for (int d = 9; d > digits[i] - '0'; d--) {
                if (lastPosition[d] > i) {
                    // Swap the digits
                    char temp = digits[i];
                    digits[i] = digits[lastPosition[d]];
                    digits[lastPosition[d]] = temp;

                    return Integer.parseInt(new String(digits));
                }
            }
        }

        return num;
    }
}
