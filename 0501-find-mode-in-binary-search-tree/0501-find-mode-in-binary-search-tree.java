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
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] findMode(TreeNode root) {
        List<Integer> modes = new ArrayList<>();
        int maxFrequency = 0;
        int currentFrequency = 0;
        int prevValue = Integer.MIN_VALUE;
        TreeNode currNode = root;

        while (currNode != null) {
            if (currNode.left == null) {
                // Process current node
                if (prevValue == currNode.val) {
                    currentFrequency++;
                } else {
                    currentFrequency = 1;
                    prevValue = currNode.val;
                }

                if (currentFrequency > maxFrequency) {
                    modes.clear();
                    modes.add(currNode.val);
                    maxFrequency = currentFrequency;
                } else if (currentFrequency == maxFrequency) {
                    modes.add(currNode.val);
                }

                currNode = currNode.right;
            } else {
                // Find the predecessor
                TreeNode predecessor = currNode.left;
                while (predecessor.right != null && predecessor.right != currNode) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    predecessor.right = currNode;
                    currNode = currNode.left;
                } else {
                    predecessor.right = null;

                    // Process current node
                    if (prevValue == currNode.val) {
                        currentFrequency++;
                    } else {
                        currentFrequency = 1;
                        prevValue = currNode.val;
                    }

                    if (currentFrequency > maxFrequency) {
                        modes.clear();
                        modes.add(currNode.val);
                        maxFrequency = currentFrequency;
                    } else if (currentFrequency == maxFrequency) {
                        modes.add(currNode.val);
                    }

                    currNode = currNode.right;
                }
            }
        }

        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }
        return result;
    }
}
