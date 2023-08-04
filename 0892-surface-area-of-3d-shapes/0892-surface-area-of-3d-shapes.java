class Solution {
    public int surfaceArea(int[][] grid) {
        int n = grid.length;
        int surfaceArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int height = grid[i][j];
                if (height > 0) {
                    // Surface area of the top and bottom faces
                    surfaceArea += 2;

                    // Surface area of the four side faces
                    surfaceArea += 4 * height;

                    // Check the adjacent cubes and subtract the shared faces
                    if (i > 0) {
                        surfaceArea -= 2 * Math.min(height, grid[i - 1][j]);
                    }
                    if (j > 0) {
                        surfaceArea -= 2 * Math.min(height, grid[i][j - 1]);
                    }
                }
            }
        }

        return surfaceArea;
    }
}
