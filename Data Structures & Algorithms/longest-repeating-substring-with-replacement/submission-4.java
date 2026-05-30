class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        int p1 = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxF = 0;

        for (int p2 = 0; p2 < s.length(); p2++) {
            map.put(s.charAt(p2), map.getOrDefault(s.charAt(p2), 0) + 1);
            maxF = Math.max(maxF, map.get(s.charAt(p2)));
            if (p2 - p1 + 1 - maxF <= k) {
                res = Math.max(res, p2 - p1 + 1);
            } else {
                map.put(s.charAt(p1), map.get(s.charAt(p1)) - 1);
                p1++;
            }
        }
        return res;
    }
}
