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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Base case: if both nodes are null, they are considered the same
        if (p == null && q == null) {
            return true;
        }
        
        // If one of the nodes is null or their values are different, they are not the same
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        
        // Recursively check if the left and right subtrees are the same
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
