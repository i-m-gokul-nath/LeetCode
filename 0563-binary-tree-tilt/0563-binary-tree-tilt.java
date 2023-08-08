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
    private int totalTilt = 0;

    public int findTilt(TreeNode root) {
        postOrderTraversal(root);
        return totalTilt;
    }

    private int postOrderTraversal(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftSum = postOrderTraversal(node.left);
        int rightSum = postOrderTraversal(node.right);

        int tilt = Math.abs(leftSum - rightSum);
        totalTilt += tilt;

        return leftSum + rightSum + node.val;
    }
}
