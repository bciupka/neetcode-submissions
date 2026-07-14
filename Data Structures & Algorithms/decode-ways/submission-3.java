class Solution {
    int[] dp;

    public int numDecodings(String s) {
        dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i] = -1;
        }
        return rec(s, 0);
    }

    private int rec(String s, int i) {
        if (i >= s.length()) return 0;
        if (s.charAt(i) == '0') return 0;
        if (i == s.length() - 1) return 1;
        if (dp[i] != -1) return dp[i];

        int res = 0;

        res += rec(s, i + 1);

        if (Integer.parseInt("" + s.charAt(i) + s.charAt(i+1)) < 27) {
            if (i == s.length() - 2) res++;
            res += rec(s, i + 2);
        }

        dp[i] = res;

        return res;
    }
}
