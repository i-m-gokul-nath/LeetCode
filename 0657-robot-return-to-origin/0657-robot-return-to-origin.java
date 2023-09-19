class Solution {
    public boolean judgeCircle(String moves) {
        int horizontal = 0;
        int vertical = 0;

        for (char move : moves.toCharArray()) {
            if (move == 'U') {
                vertical++;
            } else if (move == 'D') {
                vertical--;
            } else if (move == 'L') {
                horizontal--;
            } else if (move == 'R') {
                horizontal++;
            }
        }

        return horizontal == 0 && vertical == 0;
    }
}
