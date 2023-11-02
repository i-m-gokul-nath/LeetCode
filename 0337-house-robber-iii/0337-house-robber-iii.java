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
import java.util.HashMap;

class Solution {
    public int rob(TreeNode root) {
        return robInternal(root, new HashMap<>());
    }

    private int robInternal(TreeNode node, HashMap<TreeNode, Integer> memo) {
        if (node == null) {
            return 0;
        }
        
        if (memo.containsKey(node)) {
            return memo.get(node);
        }

        // Rob the current house
        int robCurrent = node.val +
            (node.left == null ? 0 : robInternal(node.left.left, memo) + robInternal(node.left.right, memo)) +
            (node.right == null ? 0 : robInternal(node.right.left, memo) + robInternal(node.right.right, memo));

        // Skip the current house
        int skipCurrent = robInternal(node.left, memo) + robInternal(node.right, memo);

        int result = Math.max(robCurrent, skipCurrent);
        memo.put(node, result);

        return result;
    }
}
