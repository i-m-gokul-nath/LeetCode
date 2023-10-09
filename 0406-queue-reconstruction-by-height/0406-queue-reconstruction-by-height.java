import java.util.Arrays;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        int n = people.length;
        int[][] queue = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            int k = people[i][1];
            for (int j = i; j > k; j--) {
                queue[j] = queue[j - 1];
            }
            queue[k] = people[i];
        }
        
        return queue;
    }
}
