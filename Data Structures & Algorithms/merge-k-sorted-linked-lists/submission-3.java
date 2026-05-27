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
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode dummy = new ListNode();

        for (int i = 0; i < lists.length; i++) {
            ListNode curr = lists[i];
            while (curr != null) {
                heap.offer(curr);
                curr = curr.next;
            }
        }

        ListNode curr = dummy;
        while (!heap.isEmpty()) {
            curr.next = heap.poll();
            curr = curr.next; 
        }

        return dummy.next;
    }
}
