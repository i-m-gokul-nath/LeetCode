class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer("(");
        Queue<Integer> openCount = new LinkedList<>();
        Queue<Integer> closeCount = new LinkedList();
        openCount.offer(1);
        closeCount.offer(0);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            int open = openCount.poll();
            int close = closeCount.poll();

            if (open == n && close == n) {
                result.add(current);
            }

            if (open < n) {
                queue.offer(current + "(");
                openCount.offer(open + 1);
                closeCount.offer(close);
            }
            if (close < open) {
                queue.offer(current + ")");
                openCount.offer(open);
                closeCount.offer(close + 1);
            }
        }
        
        return result;
    }
}
