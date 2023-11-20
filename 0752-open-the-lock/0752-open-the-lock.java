import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>();
        for (String deadend : deadends) {
            deadSet.add(deadend);
        }

        if (deadSet.contains("0000")) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer("0000");
        visited.add("0000");

        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                if (current.equals(target)) {
                    return moves;
                }

                for (int j = 0; j < 4; j++) {
                    for (int k = -1; k <= 1; k += 2) {
                        char[] chars = current.toCharArray();
                        chars[j] = (char) (((chars[j] - '0') + k + 10) % 10 + '0');
                        String next = new String(chars);

                        if (!visited.contains(next) && !deadSet.contains(next)) {
                            queue.offer(next);
                            visited.add(next);
                        }
                    }
                }
            }

            moves++;
        }

        return -1; // If target cannot be reached
    }
}
