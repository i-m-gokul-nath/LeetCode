/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // Check if the linked list is empty or contains only one node
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (slow != fast) {
            // If the fast pointer reaches the end of the list, there is no cycle
            if (fast == null || fast.next == null) {
                return false;
            }
            
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // If the loop exits, a cycle is detected
        return true;
    }
}
