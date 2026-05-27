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
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        ListNode merged = lists[0];

        for (int i = 1; i < lists.length; i++) {
            merged = merge(merged, lists[i]);
        }

        return merged;
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;

        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val > list2.val) {
            list2.next = merge(list1, list2.next);
            return list2;
        } else {
            list1.next = merge(list1.next, list2);
            return list1;
        }
    }
}
