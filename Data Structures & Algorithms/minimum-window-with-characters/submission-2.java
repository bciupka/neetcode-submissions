class Solution {
    public String minWindow(String s, String t) {
        int minL = Integer.MAX_VALUE;
        int[] res = {-1, -1};
        int p1 = 0;
        int have = 0;
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        final int need = tMap.size();

        for (int p2 = 0; p2 < s.length(); p2++) {
            char c = s.charAt(p2);
            if (tMap.containsKey(c)) {
                sMap.put(c, sMap.getOrDefault(c, 0) + 1);
                if (sMap.get(c) == tMap.get(c)) {
                    have++;
                }

                while (have == need) {
                    char cp1 = s.charAt(p1);
                    if (p2 - p1 + 1 < minL) {
                        minL = p2 - p1 + 1;
                        res[0] = p1;
                        res[1] = p2;
                    }

                    if (tMap.containsKey(cp1)) {
                        sMap.put(cp1, sMap.get(cp1) - 1);
                        if (sMap.get(cp1) < tMap.get(cp1)) {
                            have--;
                        }
                    }
                    p1++;
                }
            }
        }

        return minL != Integer.MAX_VALUE ? s.substring(res[0], res[1] + 1) : "";
    }
}
