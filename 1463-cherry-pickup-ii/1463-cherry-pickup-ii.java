class Solution {
    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][][] dp = new int[rows][cols][cols];

        for (int i = rows - 1; i >= 0; i--) {

            for (int j = 0; j < cols; j++) {

                for (int k = 0; k < cols; k++) {
                    int cherries = grid[i][j];

                    if (j != k) {
                        cherries += grid[i][k];
                    }

                    if (i != rows - 1) {
                        int maxCherries = 0;

                        for (int move1 = j - 1; move1 <= j + 1; move1++) {
                            for (int move2 = k - 1; move2 <= k + 1; move2++) {
                                if (move1 >= 0 && move1 < cols && move2 >= 0 && move2 < cols) {
                                    maxCherries = Math.max(maxCherries, dp[i + 1][move1][move2]);
                                }
                            }
                        }

                        dp[i][j][k] = cherries + maxCherries;
                    } else {
                        dp[i][j][k] = cherries;
                    }
                }
            }
        }
        
        return dp[0][0][cols - 1];
    }
}
