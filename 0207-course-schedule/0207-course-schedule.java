import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create an adjacency list for the directed graph.
        List<List<Integer>> adjList = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        int[] inDegrees = new int[numCourses];

        // Build the graph and calculate in-degrees.
        for (int[] prerequisite : prerequisites) {
            adjList.get(prerequisite[1]).add(prerequisite[0]);
            inDegrees[prerequisite[0]]++;
        }

        // Use a queue for topological sorting.
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }

        // Perform topological sorting.
        while (!queue.isEmpty()) {
            int course = queue.poll();
            for (int neighbor : adjList.get(course)) {
                inDegrees[neighbor]--;
                if (inDegrees[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Check if all courses can be finished.
        for (int inDegree : inDegrees) {
            if (inDegree > 0) {
                return false; // There is a cycle.
            }
        }

        return true;
    }
}
