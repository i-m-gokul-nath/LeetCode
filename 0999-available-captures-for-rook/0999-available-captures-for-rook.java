class Solution {
    public int numRookCaptures(char[][] board) {
        int[] rookPos = findRook(board);
        int x = rookPos[0];
        int y = rookPos[1];
        int captures = 0;

        // Check north
        for (int i = x - 1; i >= 0; i--) {
            if (board[i][y] == 'B') break;
            if (board[i][y] == 'p') {
                captures++;
                break;
            }
        }

        // Check south
        for (int i = x + 1; i < 8; i++) {
            if (board[i][y] == 'B') break;
            if (board[i][y] == 'p') {
                captures++;
                break;
            }
        }

        // Check west
        for (int j = y - 1; j >= 0; j--) {
            if (board[x][j] == 'B') break;
            if (board[x][j] == 'p') {
                captures++;
                break;
            }
        }

        // Check east
        for (int j = y + 1; j < 8; j++) {
            if (board[x][j] == 'B') break;
            if (board[x][j] == 'p') {
                captures++;
                break;
            }
        }

        return captures;
    }

    private int[] findRook(char[][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1}; // Rook not found (shouldn't happen in valid input).
    }
}
