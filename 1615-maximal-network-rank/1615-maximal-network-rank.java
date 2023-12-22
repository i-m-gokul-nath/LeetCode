import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] degree = new int[n];
        Set<Integer>[] connectedCities = new Set[n];
        for (int i = 0; i < n; i++) {
            connectedCities[i] = new HashSet<>();
        }
        for (int[] road : roads) {
            degree[road[0]]++;
            degree[road[1]]++;
            connectedCities[road[0]].add(road[1]);
            connectedCities[road[1]].add(road[0]);
        }

        int maxNetworkRank = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int networkRank = degree[i] + degree[j];
                if (connectedCities[i].contains(j) || connectedCities[j].contains(i)) {
                    networkRank--;
                }
                maxNetworkRank = Math.max(maxNetworkRank, networkRank);
            }
        }

        return maxNetworkRank;
    }
}
