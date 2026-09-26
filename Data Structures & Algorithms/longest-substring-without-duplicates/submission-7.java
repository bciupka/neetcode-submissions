class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        int l, r, res;
        Set<Character> seen = new HashSet<>();
        l = r = res = 0; 

        while (r < s.length()) {
            char cur = s.charAt(r);
            if (seen.contains(cur)) {
                while (s.charAt(l) != cur) {
                    seen.remove(s.charAt(l));
                    l++;
                }
                l++;
            }
            seen.add(cur);
            res = Math.max(res, r - l + 1);
            r++;
        }

        return res;

    }
}
