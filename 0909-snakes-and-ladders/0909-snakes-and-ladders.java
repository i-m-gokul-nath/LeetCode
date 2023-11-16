import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int target = n * n;

        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[target + 1];

        // Start from the bottom-left corner (square 1)
        queue.offer(1);
        visited[1] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // Check if we have reached the target square
            if (current == target) {
                return visited[current] - 1; // Subtract 1 to get the number of moves
            }

            // Explore next possible moves
            for (int i = 1; i <= 6; i++) {
                int next = current + i;

                if (next > target) {
                    break; // Skip if we exceed the board size
                }

                int[] pos = getPosition(next, n);
                int nextRow = pos[0];
                int nextCol = pos[1];

                if (board[nextRow][nextCol] != -1) {
                    // If there is a snake or ladder, use its destination
                    next = board[nextRow][nextCol];
                }

                if (visited[next] == 0) {
                    visited[next] = visited[current] + 1;
                    queue.offer(next);
                }
            }
        }

        return -1; // If no solution is found
    }

    private int[] getPosition(int num, int n) {
        int row = n - 1 - (num - 1) / n;
        int col = ((n - 1 - row) % 2 == 0) ? (num - 1) % n : n - 1 - (num - 1) % n;
        return new int[]{row, col};
    }
}
