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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode(0);
        dummy.next = list1;
        
        ListNode prevA = dummy;
        for (int i = 0; i < a; i++) {
            prevA = prevA.next;
        }
        
        ListNode currB = prevA;
        for (int i = 0; i < b - a + 2; i++) {
            currB = currB.next;
        }
        
        ListNode lastList2 = list2;
        while (lastList2.next != null) {
            lastList2 = lastList2.next;
        }
        
        prevA.next = list2;
        lastList2.next = currB;
        
        return dummy.next;
    }
}