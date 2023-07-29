import java.util.*;

class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int duplicate = -1;
        int sum = 0;

        for (int num : nums) {
            if (!set.add(num)) {
                duplicate = num;
            }
            sum += num;
        }

        int missing = n * (n + 1) / 2 - sum + duplicate;
        return new int[] { duplicate, missing };
    }
}
