import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        dfs(0, graph, currentPath, paths);
        return paths;
    }

    private void dfs(int node, int[][] graph, List<Integer> currentPath, List<List<Integer>> paths) {
        currentPath.add(node);

        if (node == graph.length - 1) {
            // Reached the target node, add the current path to the result.
            paths.add(new ArrayList<>(currentPath));
        } else {
            for (int neighbor : graph[node]) {
                // Recursively explore neighbors.
                dfs(neighbor, graph, currentPath, paths);
            }
        }

        // Backtrack by removing the current node from the path.
        currentPath.remove(currentPath.size() - 1);
    }
}
