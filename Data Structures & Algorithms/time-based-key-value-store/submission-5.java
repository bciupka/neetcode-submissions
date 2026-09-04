class TimeMap {
    Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
        
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new TreeMap<>());
        TreeMap<Integer, String> cur = map.get(key);
        cur.put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> cur = map.get(key);
        if (cur == null) return "";

        Map.Entry<Integer, String> res = cur.floorEntry(timestamp);
        return res == null ? "" : res.getValue();
    }
}
