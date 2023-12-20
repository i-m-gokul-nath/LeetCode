import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] incomingEdges = new int[n];

        for (List<Integer> edge : edges) {
            int to = edge.get(1);
            incomingEdges[to]++;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (incomingEdges[i] == 0) {
                result.add(i);
            }
        }

        return result;
    }
}
