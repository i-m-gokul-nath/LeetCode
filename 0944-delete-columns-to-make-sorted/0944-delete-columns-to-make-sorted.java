class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs[0].length(); // Length of each string
        int count = 0; // Counter for deleted columns
        
        // Iterate through each column
        for (int col = 0; col < n; col++) {
            // Check if the column is sorted
            for (int row = 1; row < strs.length; row++) {
                if (strs[row].charAt(col) < strs[row - 1].charAt(col)) {
                    // Column is not sorted, increment the counter and move to the next column
                    count++;
                    break;
                }
            }
        }
        
        return count;
    }
}
