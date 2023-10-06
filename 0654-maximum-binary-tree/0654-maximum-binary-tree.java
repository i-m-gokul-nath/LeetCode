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
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaxBinaryTree(nums, 0, nums.length - 1);
    }

    private TreeNode constructMaxBinaryTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int maxIndex = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        TreeNode root = new TreeNode(nums[maxIndex]);

        root.left = constructMaxBinaryTree(nums, left, maxIndex - 1);
        root.right = constructMaxBinaryTree(nums, maxIndex + 1, right);

        return root;
    }
}
