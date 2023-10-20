class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0];
        int col = click[1];

        if (board[row][col] == 'M') {
            board[row][col] = 'X'; // Game over
        } else {
            reveal(board, row, col);
        }
        return board;
    }

    private void reveal(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != 'E') {
            return;
        }

        int mines = countAdjacentMines(board, row, col);

        if (mines == 0) {
            board[row][col] = 'B';

            for (int r = -1; r <= 1; r++) {
                for (int c = -1; c <= 1; c++) {
                    if (r == 0 && c == 0) continue;
                    reveal(board, row + r, col + c);
                }
            }
        } else {
            board[row][col] = (char) (mines + '0');
        }
    }

    private int countAdjacentMines(char[][] board, int row, int col) {
        int mines = 0;
        for (int r = -1; r <= 1; r++) {
            for (int c = -1; c <= 1; c++) {
                if (r == 0 && c == 0) continue;
                int newRow = row + r;
                int newCol = col + c;

                if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length) {
                    if (board[newRow][newCol] == 'M') {
                        mines++;
                    }
                }
            }
        }
        return mines;
    }
}
