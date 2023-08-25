class Solution {
    public int calPoints(String[] operations) {
        int[] stack = new int[operations.length];
        int totalSum = 0;
        int top = -1;

        for (String op : operations) {
            if (op.equals("C")) {
                if (top >= 0) {
                    totalSum -= stack[top];
                    top--;
                }
            } else if (op.equals("D")) {
                if (top >= 0) {
                    int newScore = stack[top] * 2;
                    stack[top + 1] = newScore;
                    totalSum += newScore;
                    top++;
                }
            } else if (op.equals("+")) {
                if (top >= 1) {
                    int newScore = stack[top] + stack[top - 1];
                    stack[top + 1] = newScore;
                    totalSum += newScore;
                    top++;
                }
            } else {
                int score = Integer.parseInt(op);
                stack[top + 1] = score;
                totalSum += score;
                top++;
            }
        }

        return totalSum;
    }
}
