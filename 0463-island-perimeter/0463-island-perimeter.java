class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4; // Each land cell contributes 4 edges

                    // Check left neighbor
                    if (j > 0 && grid[i][j - 1] == 1) {
                        perimeter -= 2; // Subtract 2 as left neighbor has common edge
                    }

                    // Check top neighbor
                    if (i > 0 && grid[i - 1][j] == 1) {
                        perimeter -= 2; // Subtract 2 as top neighbor has common edge
                    }
                }
            }
        }

        return perimeter;
    }
}
