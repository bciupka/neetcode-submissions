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
    public void reorderList(ListNode head) {
        ListNode slow = head; 
        ListNode fast = head.next;

        // finding middle point 
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse second half
        ListNode second = slow.next;
        ListNode prev = null;
        while (second != null) {
            ListNode tmp = second.next;            
            second.next = prev;
            prev = second;
            second = tmp;
        }

        slow.next = null; // splitting list in the middle

        // merging two lists
        second = prev; // start of the second is at the last element of initial list

        while (second != null) {
            ListNode tmp = head.next;
            ListNode tmp2 = second.next;
            head.next = second;
            second.next = tmp;
            head = tmp;
            second = tmp2;
        }
    }
}
