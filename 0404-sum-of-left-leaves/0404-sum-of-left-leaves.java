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
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int sum = 0;
        
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val; // Add the value of the left leaf node
        }
        
        sum += sumOfLeftLeaves(root.left); // Recursively traverse left subtree
        sum += sumOfLeftLeaves(root.right); // Recursively traverse right subtree
        
        return sum;
    }
}
