class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> lookup = new HashSet<>();
        int max = 0;    
        int p1 = 0;
        int p2 = 0;

        while (p2 < s.length()) {
            while (lookup.contains(s.charAt(p2))) {
                lookup.remove(s.charAt(p1));
                p1++;
            }
            lookup.add(s.charAt(p2));
            max = Math.max(max, p2 - p1 + 1);
            p2++;
        }
        return max;
    }
}
