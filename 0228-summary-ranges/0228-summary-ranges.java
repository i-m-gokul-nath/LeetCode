import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int start = nums[i];
            while (i < n - 1 && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            int end = nums[i];
            
            if (start == end) {
                result.add(Integer.toString(start));
            } else {
                result.add(start + "->" + end);
            }
        }

        return result;
    }
}
