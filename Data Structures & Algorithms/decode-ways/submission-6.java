class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[n] = 1;

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = s.charAt(i) == '0' ? 0 : dp[i+1];

            if (check(s, i)) {
                dp[i] += dp[i+2];
            }
        }

        return dp[0];

    }

    private boolean check(String s, int i) {
        int n = s.length();
        if (i + 1 < n) {
            int num = Integer.parseInt("" + s.charAt(i) + s.charAt(i+1));
            if (num > 9 && num < 27) return true;
        }
        return false;
    }
}
