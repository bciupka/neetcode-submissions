class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> lookup = new HashSet<>();
        int max = 0;    
        int p1 = 0;

        for (int p2 = 0; p2 < s.length(); p2++) {
            while (lookup.contains(s.charAt(p2))) {
                lookup.remove(s.charAt(p1));
                p1++;
            }
            lookup.add(s.charAt(p2));
            max = Math.max(max, p2 - p1 + 1);
        }
        return max;
    }
}
