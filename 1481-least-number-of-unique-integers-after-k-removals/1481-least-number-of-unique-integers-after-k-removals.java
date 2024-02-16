import java.util.*;

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> counts = new ArrayList<>(countMap.values());
        Collections.sort(counts);

        int uniqueIntegers = counts.size();
        for (int count : counts) {
            if (k >= count) {
                k -= count;
                uniqueIntegers--;
            } else {
                break;
            }
        }

        return uniqueIntegers;
    }
}