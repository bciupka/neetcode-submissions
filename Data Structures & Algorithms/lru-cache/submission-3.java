class LRUCache {
    Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        map = new LinkedHashMap<>() {
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> _entry) {
               return size() > capacity;
            }
        };
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            int val = map.remove(key);
            map.put(key, val);
            return val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
        }
        map.put(key, value);
    }
}
