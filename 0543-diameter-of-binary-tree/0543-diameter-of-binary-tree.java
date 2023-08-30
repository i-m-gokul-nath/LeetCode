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
    private int maxDiameter = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }
    
    private int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);
        
        // Calculate the diameter passing through the current node
        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);
        
        // Return the depth of the current node
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
