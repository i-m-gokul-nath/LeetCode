/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> sumFrequency = new HashMap<>();
        int[] maxFrequency = new int[]{0};

        calculateSubtreeSums(root, sumFrequency, maxFrequency);

        List<Integer> frequentSums = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : sumFrequency.entrySet()) {
            if (entry.getValue() == maxFrequency[0]) {
                frequentSums.add(entry.getKey());
            }
        }

        int[] result = new int[frequentSums.size()];
        for (int i = 0; i < frequentSums.size(); i++) {
            result[i] = frequentSums.get(i);
        }

        return result;
    }

    private int calculateSubtreeSums(TreeNode node, Map<Integer, Integer> sumFrequency, int[] maxFrequency) {
        if (node == null) {
            return 0;
        }

        int leftSum = calculateSubtreeSums(node.left, sumFrequency, maxFrequency);
        int rightSum = calculateSubtreeSums(node.right, sumFrequency, maxFrequency);

        int currentSum = leftSum + rightSum + node.val;

        sumFrequency.put(currentSum, sumFrequency.getOrDefault(currentSum, 0) + 1);

        maxFrequency[0] = Math.max(maxFrequency[0], sumFrequency.get(currentSum));

        return currentSum;
    }
}