import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n]; // 0: not visited, 1: visiting, 2: visited (safe)

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (dfs(i, graph, color)) {
                result.add(i);
            }
        }

        return result;
    }

    private boolean dfs(int node, int[][] graph, int[] color) {
        if (color[node] > 0) {
            return color[node] == 2;
        }

        color[node] = 1; // Mark as visiting

        for (int neighbor : graph[node]) {
            if (!dfs(neighbor, graph, color)) {
                return false;
            }
        }

        color[node] = 2; // Mark as visited and safe
        return true;
    }
}
