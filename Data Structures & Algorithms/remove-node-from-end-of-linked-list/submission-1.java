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
        return delete(head, new int[]{n});
    }

    private ListNode delete(ListNode curr, int[] nMutable) { // need for check of n variable value after passing it to recurse call
        if (curr == null) return null;

        curr.next = delete(curr.next, nMutable);
        nMutable[0]--;
        if (nMutable[0] == 0) {
            return curr.next;
        }

        return curr;
    }
}
