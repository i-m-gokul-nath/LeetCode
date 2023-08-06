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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftDepth = leftDepth(root);
        int rightDepth = rightDepth(root);
        
        // If the left and right depths are equal, the tree is a full binary tree
        if (leftDepth == rightDepth) {
            return (1 << leftDepth) - 1; // Equivalent to 2^depth - 1
        }
        
        // If the tree is not full, we count nodes in the last level
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    private int leftDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            depth++;
            root = root.left;
        }
        return depth;
    }
    
    private int rightDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            depth++;
            root = root.right;
        }
        return depth;
    }
}
