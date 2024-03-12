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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        HashMap<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        ListNode current = dummy;

        while (current != null) {
            sum += current.val;

            if (map.containsKey(sum)) {
                current = map.get(sum).next;
                int tempSum = sum + current.val;
                while (tempSum != sum) {
                    map.remove(tempSum);
                    current = current.next;
                    tempSum += current.val;
                }
                map.get(sum).next = current.next;
            } else {
                map.put(sum, current);
            }

            current = current.next;
        }

        return dummy.next;
    }
}