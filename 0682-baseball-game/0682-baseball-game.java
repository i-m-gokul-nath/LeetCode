import java.util.Stack;

class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int totalSum = 0;
        
        for (String op : operations) {
            if (op.equals("C")) {
                if (!stack.isEmpty()) {
                    totalSum -= stack.pop(); // Remove and subtract the last score from the sum
                }
            } else if (op.equals("D")) {
                if (!stack.isEmpty()) {
                    int prevScore = stack.peek();
                    int newScore = prevScore * 2;
                    stack.push(newScore); // Push the new score onto the stack
                    totalSum += newScore; // Add the new score to the sum
                }
            } else if (op.equals("+")) {
                if (stack.size() >= 2) {
                    int lastScore = stack.pop();
                    int secondLastScore = stack.peek();
                    int newScore = lastScore + secondLastScore;
                    stack.push(lastScore);
                    stack.push(newScore); // Push the new score onto the stack
                    totalSum += newScore; // Add the new score to the sum
                }
            } else {
                int score = Integer.parseInt(op);
                stack.push(score); // Push the integer score onto the stack
                totalSum += score; // Add the score to the sum
            }
        }
        
        return totalSum;
    }
}
