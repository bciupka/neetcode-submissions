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
        int length = 0;
        ListNode p = head;

        while(p != null) {
            length++;
            p = p.next;
        }

        int pointOfMod = length - n - 1;
        p = head;
        ListNode prev = null;

        for (int i = 0; i <= pointOfMod; i++) {
            prev = p;
            p = p.next;
        }

        if (prev != null) {
            prev.next = p.next;
        } else {
            head = head.next;
        }

        return head;
    }
}
