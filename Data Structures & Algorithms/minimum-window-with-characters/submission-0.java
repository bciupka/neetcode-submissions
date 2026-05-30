class Solution {
    public String minWindow(String s, String t) {
        String res = "";
        int minL = Integer.MAX_VALUE;
        Map<Character, Integer> counts = new HashMap<>();
        
        for (char c : t.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        int p1 = 0;

        for (int p2 = 0; p2 < s.length(); p2++) {
            char c = s.charAt(p2);
            if (counts.containsKey(c)) {
                counts.put(c, counts.get(c) - 1);
            }

            while (allUsed(counts)) {
                if (p2 - p1 + 1 < minL) {
                    minL = p2 - p1 + 1;
                    res = s.substring(p1, p2 + 1);
                }
                char cp1 = s.charAt(p1);
                if (counts.containsKey(cp1)) {
                    counts.put(cp1, counts.get(cp1) + 1);
                }
                p1++;
            }
        }
        
        return res;
    }

    private boolean allUsed(Map<Character, Integer> counts) {
        return Collections.max(counts.values()) > 0 ? false : true;
    }
}
