/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int length = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            length++;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        for (int step = 1; step < length; step <<= 1) {
            ListNode prev = dummy;
            current = dummy.next;
            while (current != null) {
                ListNode left = current;
                ListNode right = split(left, step);
                current = split(right, step);
                prev = merge(left, right, prev);
            }
        }
        
        return dummy.next;
    }
    
    private ListNode split(ListNode head, int step) {
        if (head == null) {
            return null;
        }
        for (int i = 1; head.next != null && i < step; i++) {
            head = head.next;
        }
        ListNode right = head.next;
        head.next = null;
        return right;
    }
    
    private ListNode merge(ListNode left, ListNode right, ListNode prev) {
        ListNode current = prev;
        while (left != null && right != null) {
            if (left.val < right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }
        current.next = (left != null) ? left : right;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }
}
