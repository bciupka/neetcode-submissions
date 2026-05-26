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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode p2 = dummy;
        int count = 0;

        while (p2.next != null) {
            p2 = p2.next;
            if (count >= n) {
                p1 = p1.next;
            }
            count++;
        }

        p1.next = p1.next.next;

        return dummy.next;
    }
}
