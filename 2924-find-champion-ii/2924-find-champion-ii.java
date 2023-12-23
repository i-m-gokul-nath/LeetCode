import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int findChampion(int n, int[][] edges) {
        if (n == 1) {

            return 0;
        }

        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            inDegree[v]++;
        }

        int zeroInDegreeCount = 0;
        int zeroInDegreeTeam = -1;
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                zeroInDegreeCount++;
                zeroInDegreeTeam = i;
            }
        }

        if (zeroInDegreeCount != 1) {

            return -1;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(zeroInDegreeTeam);
        while (!queue.isEmpty()) {
            int currentTeam = queue.poll();
            for (int neighbor : graph.get(currentTeam)) {
                if (--inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (inDegree[i] > 0) {
 
                return -1;
            }
        }

        return zeroInDegreeTeam;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n1 = 3;
        int[][] edges1 = {{0, 1}, {1, 2}};
        System.out.println(solution.findChampion(n1, edges1)); // Output: 0

        int n2 = 4;
        int[][] edges2 = {{0, 2}, {1, 3}, {1, 2}};
        System.out.println(solution.findChampion(n2, edges2)); // Output: -1

        int n3 = 1;
        int[][] edges3 = {};
        System.out.println(solution.findChampion(n3, edges3)); // Output: 0

        int n4 = 3;
        int[][] edges4 = {{0, 2}, {0, 1}};
        System.out.println(solution.findChampion(n4, edges4)); // Output: -1
    }
}