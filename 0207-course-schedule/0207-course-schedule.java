import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        int[] inDegrees = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            adjList.get(prerequisite[1]).add(prerequisite[0]);
            inDegrees[prerequisite[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0; // Count of courses with in-degree 0.

        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;

            for (int neighbor : adjList.get(course)) {
                inDegrees[neighbor]--;
                if (inDegrees[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return count == numCourses;
    }
}