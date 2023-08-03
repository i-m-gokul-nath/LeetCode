class Solution {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }

        char[] hexDigits = "0123456789abcdef".toCharArray();
        StringBuilder sb = new StringBuilder();

        while (num != 0) {
            int digit = num & 0xf; // Extract the last 4 bits (one hexadecimal digit)
            sb.append(hexDigits[digit]);
            num >>>= 4; // Right shift the number by 4 bits
        }

        return sb.reverse().toString();
    }
}
