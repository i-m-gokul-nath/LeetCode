class Solution {
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int xyProjection = 0;
        int yzProjection = 0;
        int zxProjection = 0;
        
        for (int i = 0; i < n; i++) {
            int maxRow = 0;
            int maxCol = 0;
            
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    xyProjection++; // Count the number of cubes on the xy-plane
                }
                
                maxRow = Math.max(maxRow, grid[i][j]); // Max height in current row
                maxCol = Math.max(maxCol, grid[j][i]); // Max height in current column
            }
            
            yzProjection += maxRow; // Sum of max heights in each row for the yz-plane
            zxProjection += maxCol; // Sum of max heights in each column for the zx-plane
        }
        
        return xyProjection + yzProjection + zxProjection;
    }
}
