class TimeMap {
    private Map<String, List<String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        List<String> cur = map.get(key);
        cur.add(timestamp + "@" + value);
    }
    
    public String get(String key, int timestamp) {
        List<String> cur = map.get(key);
        if (cur == null) return "";

        int l = 0, r = cur.size() - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            int mTime = Integer.parseInt(cur.get(m).split("@")[0]);

            if (mTime == timestamp) return cur.get(m).split("@")[1];
            if (mTime > timestamp) {
                r = m - 1;
                continue;
            }

            l = m + 1;
        }

        int ind = Math.max(0, r);

        return Integer.parseInt(cur.get(ind).split("@")[0]) <= timestamp ? cur.get(ind).split("@")[1] : "";
    }


}
