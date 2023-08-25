import java.util.Stack;

class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        
        for (String op : operations) {
            if (op.equals("C")) {
                if (!stack.isEmpty()) {
                    stack.pop(); // Remove the last score
                }
            } else if (op.equals("D")) {
                if (!stack.isEmpty()) {
                    int prevScore = stack.peek();
                    stack.push(prevScore * 2); // Double the last score
                }
            } else if (op.equals("+")) {
                if (stack.size() >= 2) {
                    int lastScore = stack.pop();
                    int secondLastScore = stack.peek();
                    stack.push(lastScore);
                    stack.push(lastScore + secondLastScore); // Add the sum of the last two scores
                }
            } else {
                stack.push(Integer.parseInt(op)); // Add the integer score to the stack
            }
        }
        
        int totalSum = 0;
        for (int score : stack) {
            totalSum += score;
        }
        
        return totalSum;
    }
}
