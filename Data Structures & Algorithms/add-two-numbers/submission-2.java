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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return rec(l1, l2, 0);
    }

    private ListNode rec(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) return null;
        if (l1 == null && l2 == null) return new ListNode(carry);

        ListNode cur = new ListNode();

        int res;
        ListNode newL1;
        ListNode newL2; 

        if (l1 == null) {
            res = l2.val + carry;
            newL1 = null;
            newL2 = l2.next;
        } else if (l2 == null) {
            res = l1.val + carry;
            newL1 = l1.next;
            newL2 = null;
        } else {
            res = l1.val + l2.val + carry;
            newL1 = l1.next;
            newL2 = l2.next;
        }

        int digit = res % 10;
        int newCarry = res / 10;
        cur.val = digit;

        cur.next = rec(newL1, newL2, newCarry);
        return cur;
    }
}
