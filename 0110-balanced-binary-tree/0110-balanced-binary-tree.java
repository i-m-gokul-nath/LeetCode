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
    public boolean isBalanced(TreeNode root) {
        // Base case: an empty tree is considered balanced
        if (root == null) {
            return true;
        }
        
        // Check if the left subtree is balanced
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1) {
            return false;
        }
        
        // Check if the right subtree is balanced
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1) {
            return false;
        }
        
        // Check if the current node is balanced
        int heightDiff = Math.abs(leftHeight - rightHeight);
        if (heightDiff > 1) {
            return false;
        }
        
        // The tree is balanced if both subtrees are balanced
        return true;
    }
    
    private int getHeight(TreeNode node) {
        // Base case: an empty subtree has height 0
        if (node == null) {
            return 0;
        }
        
        // Recursively calculate the height of the left and right subtrees
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        
        // If either subtree is unbalanced, return -1 to indicate unbalance
        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }
        
        // Check if the current node is balanced
        int heightDiff = Math.abs(leftHeight - rightHeight);
        if (heightDiff > 1) {
            return -1;
        }
        
        // Return the height of the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
