class Node {
    Node prev;
    Node next;
    int key;
    int val;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    Map<Integer, Node> map;
    Node left;
    Node right;
    int cap;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        cap = capacity; 
        left = new Node(0, 0);
        right = new Node(0, 0);
        left.next = right;
        right.prev = left;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node cur = map.get(key);
            remove(cur);
            insert(cur);
            return cur.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        
        Node cur = new Node(key, value);
        map.put(key, cur);
        insert(cur);
        
        if (map.size() > cap) {
            map.remove(left.next.key);
            remove(left.next);
        }
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        node.next = right;
        right.prev.next = node;
        node.prev = right.prev;
        right.prev = node;
    }
}
