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
    Map<Integer, Node> nodes;

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        nodes = new HashMap<>();

        return dfs(node);
    }

    private Node dfs(Node node) {
        if (nodes.containsKey(node.val)) return nodes.get(node.val);

        Node clone = new Node(node.val);
        nodes.put(node.val, clone);

        for (Node nei : node.neighbors) {
            clone.neighbors.add(dfs(nei));
        }

        return clone;
    }
}