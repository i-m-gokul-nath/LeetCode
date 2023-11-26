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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Check if the input arrays are empty
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        
        // Build the tree using recursive helper function
        return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    private TreeNode buildTreeHelper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        // Base case
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        
        // The last element in postorder is the root of the current subtree
        int rootValue = postorder[postEnd];
        TreeNode root = new TreeNode(rootValue);
        
        // Find the index of the root value in the inorder array
        int rootIndexInorder = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootValue) {
                rootIndexInorder = i;
                break;
            }
        }
        
        // Build the right and left subtrees recursively
        root.left = buildTreeHelper(inorder, inStart, rootIndexInorder - 1, postorder, postStart, postStart + (rootIndexInorder - inStart) - 1);
        root.right = buildTreeHelper(inorder, rootIndexInorder + 1, inEnd, postorder, postStart + (rootIndexInorder - inStart), postEnd - 1);
        
        return root;
    }
}
