class Solution {
    int[] dp;

    public int numDecodings(String s) {
        int n = s.length();
        dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            dp[i] = -1;
        }
        dp[n] = 1;
        return rec(s, 0);
    }

    private int rec(String s, int i) {
        if (dp[i] != -1) return dp[i];
        if (s.charAt(i) == '0') return 0;

        int res = rec(s, i + 1);

        if (i + 1 < s.length() && Integer.parseInt("" + s.charAt(i) + s.charAt(i+1)) < 27) {
            res += rec(s, i + 2);
        }

        dp[i] = res;

        return res;
    }
}
