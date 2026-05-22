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
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        return doSwapping(head, null);
        
    }

    private ListNode doSwapping(ListNode curr ,ListNode prev) {
       ListNode temp = curr.next;
       curr.next = prev;
       if (temp == null) return curr;
       return doSwapping(temp, curr);
    }
}
