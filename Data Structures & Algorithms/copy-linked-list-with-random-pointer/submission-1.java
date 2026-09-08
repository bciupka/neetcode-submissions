/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    Map<Node, Node> nodesMap;

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        nodesMap = new HashMap<>();
        nodesMap.put(null, null);

        Node cur = head;
        while (cur != null) {
            Node copy = new Node(cur.val);
            nodesMap.put(cur, copy);
            cur = cur.next;
        }

        cur = head;

        while (cur != null) {
            Node copy = nodesMap.get(cur);
            copy.next = nodesMap.get(cur.next);
            copy.random = nodesMap.get(cur.random);
            cur = cur.next;
        }

        return nodesMap.get(head);
    }
}
