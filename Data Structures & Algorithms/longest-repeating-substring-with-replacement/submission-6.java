class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        int p1 = 0;
        int maxF = 0;
        int[] freq = new int[26];

        for (int p2 = 0; p2 < s.length(); p2++) {
            char c = s.charAt(p2);
            freq[c - 'A']++;
            maxF = Math.max(maxF, freq[c - 'A']);
            if (p2 - p1 + 1 - maxF <= k) {
                res = Math.max(res, p2 - p1 + 1);
            } else {
                freq[s.charAt(p1) - 'A']--;
                p1++;
            }
        }
        return res;
    }
}
