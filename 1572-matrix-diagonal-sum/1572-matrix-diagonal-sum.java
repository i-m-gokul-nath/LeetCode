class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            sum += mat[i][i]; // Add elements of the primary diagonal
            sum += mat[i][n - 1 - i]; // Add elements of the secondary diagonal
        }
        
        // If the matrix size is odd, subtract the duplicate middle element
        if (n % 2 == 1) {
            sum -= mat[n / 2][n / 2];
        }
        
        return sum;
    }
}
