import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        findCombinations(candidates, target, 0, currentList, result);
        return result;
    }

    private void findCombinations(int[] candidates, int target, int start, List<Integer> currentList, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                currentList.add(candidates[i]);
                findCombinations(candidates, target - candidates[i], i, currentList, result);
                currentList.remove(currentList.size() - 1);
            }
        }
    }
}
