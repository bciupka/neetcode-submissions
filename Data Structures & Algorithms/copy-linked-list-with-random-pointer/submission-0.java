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

        Node newHead = new Node(head.val);
        nodesMap.put(head, newHead);

        Node newCur = newHead;
        Node oldCur = head;

        while (oldCur.next != null) {
            Node next = new Node(oldCur.next.val);
            oldCur = oldCur.next;
            nodesMap.put(oldCur, next);
            newCur.next = next;
            newCur = next;
        }

        newCur = newHead;
        oldCur = head;

        while (newCur != null) {
            if (oldCur.random != null) {
                Node newRandom = nodesMap.get(oldCur.random);
                newCur.random = newRandom;
            }
            newCur = newCur.next;
            oldCur = oldCur.next;
        }

        return newHead;
    }
}
