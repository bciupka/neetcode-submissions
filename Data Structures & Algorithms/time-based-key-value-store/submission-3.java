class TimeMap {
    private Map<String, List<Pair<Integer, String>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>()); 
        List<Pair<Integer, String>> cur = map.get(key);
        cur.add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> cur = map.get(key);
        if (cur == null) return "";

        int l = 0;
        int r = cur.size() - 1;
        String res = "";

        while (l <= r) {
            int m = (l + r) / 2;
            Pair<Integer, String> mVal = cur.get(m);

            if (mVal.getKey() == timestamp) return mVal.getValue();

            if (mVal.getKey() < timestamp) {
                res = mVal.getValue();
                l = m + 1;
                continue;
            }

            r = m - 1;
        }

        return res;
    }

    private class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }
        
        public V getValue() {
            return value;
        }
    }
}
