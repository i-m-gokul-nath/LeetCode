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
    // Initialize the dummy node to simplify tree construction
    TreeNode dummy = new TreeNode(-1);
    TreeNode current = dummy;

    public TreeNode increasingBST(TreeNode root) {
        inOrderTraversal(root);
        return dummy.right;
    }

    private void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        
        inOrderTraversal(node.left);

        // Update the current node's right child and clear its left child
        current.right = new TreeNode(node.val);
        current = current.right;
        
        inOrderTraversal(node.right);
    }
}
