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
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int minDepth(TreeNode root) {
        // Check if the tree is empty
        if (root == null) {
            return 0;
        }
        
        // Use a queue to perform level order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        // Initialize the depth to 1
        int depth = 1;
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            
            // Traverse the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                
                // Check if the node is a leaf node
                if (node.left == null && node.right == null) {
                    return depth;
                }
                
                // Add the child nodes to the queue
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            
            // Increment the depth after traversing each level
            depth++;
        }
        
        return depth;
    }
}
