import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        
        List<int[]> queue = new ArrayList<>();
        
        for (int[] person : people) {
            queue.add(person[1], person);
        }
        
        // Convert the ArrayList to an array
        return queue.toArray(new int[people.length][2]);
    }
}
