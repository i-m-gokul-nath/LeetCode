class Solution {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0"; // Handle the special case where num is 0
        }

        boolean isNegative = num < 0;
        num = Math.abs(num); // Convert num to positive to simplify the logic

        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int digit = num % 7; // Extract the least significant digit
            sb.append(digit); // Append the digit to the result string
            num /= 7; // Remove the least significant digit
        }

        if (isNegative) {
            sb.append("-"); // Add a negative sign to the result if num is negative
        }

        return sb.reverse().toString(); // Reverse the result string and return
    }
}
