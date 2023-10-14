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
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findPaths(root, targetSum, currentPath, result);
        return result;
    }

    private void findPaths(TreeNode node, int target, List<Integer> path, List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        path.add(node.val);
        target -= node.val;

        if (node.left == null && node.right == null && target == 0) {
            result.add(new ArrayList<>(path));
        } else {
            findPaths(node.left, target, path, result);
            findPaths(node.right, target, path, result);
        }

        path.remove(path.size() - 1);
    }
}
