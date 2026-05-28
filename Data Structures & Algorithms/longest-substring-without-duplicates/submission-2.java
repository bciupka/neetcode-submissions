class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> lookup = new HashSet<>();
        int max = 0;
        int curr = 0;
        int p1, p2;
        p1 = p2 = 0;

        while (p2 < s.length()) {
            char c2 = s.charAt(p2);
            if (!lookup.contains(c2)) {
                curr++;
                lookup.add(c2);
                max = Math.max(curr, max);
                p2++;
            } else{
                while (true) {
                    curr--;
                    char c1 = s.charAt(p1);
                    p1++;
                    lookup.remove(c1);
                    if (c1 == c2) {
                        break;
                    }
                }
            }
        }

        return max;

    }
}
