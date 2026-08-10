/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> nodes = new HashMap<>();
        Deque<Node> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            Node curr = q.poll();

            Node clone = nodes.getOrDefault(curr, new Node(curr.val));
            nodes.put(curr, clone);

            for (Node nei : curr.neighbors) {
                Node neiClone;
                if (!nodes.containsKey(nei)) {
                    neiClone = new Node(nei.val);
                    nodes.put(nei, neiClone);
                    q.add(nei);
                } else {
                    neiClone = nodes.get(nei);
                }

                clone.neighbors.add(neiClone);
            }
        }

        return nodes.get(node);
        
    }
}