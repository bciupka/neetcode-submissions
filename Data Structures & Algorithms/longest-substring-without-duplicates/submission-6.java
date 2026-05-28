class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lookup = new HashMap<>();
        int max = 0;    
        int p1 = 0;
        int p2 = 0;

        while (p2 < s.length()) {
            if (lookup.containsKey(s.charAt(p2))) {
                p1 = Math.max(lookup.get(s.charAt(p2)) + 1, p1);
            }
            lookup.put(s.charAt(p2), p2);
            p2++;
            max = Math.max(max, p2 - p1);
        }
        return max;
    }
}
