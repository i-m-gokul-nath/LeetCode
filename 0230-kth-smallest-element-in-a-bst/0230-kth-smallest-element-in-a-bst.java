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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        inOrderTraversal(root, result, k);
        return result.get(k - 1);
    }
    
    private void inOrderTraversal(TreeNode node, List<Integer> result, int k) {
        if (node == null || result.size() >= k) {
            return;
        }
        
        inOrderTraversal(node.left, result, k);
        if (result.size() < k) {
            result.add(node.val);
        }
        inOrderTraversal(node.right, result, k);
    }
}
