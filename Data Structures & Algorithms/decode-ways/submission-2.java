class Solution {
        int[][] dp; 
    public int numDecodings(String s) {
        dp = new int[s.length()][2];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j] = -1;
            }
        }
        return rec(s, 0, 1) + rec(s, 0, 2);
    }

    private int rec(String s, int i, int variant) {
        if (s.charAt(i) == '0') return 0;
        if (dp[i][variant - 1] != -1) return dp[i][variant - 1];
        int newI;

        if (variant == 1) {
            if (i >= s.length()) return 0;

            if (i == s.length() - 1) return 1;

            newI = i + 1;
        } else {
            if (i >= s.length() - 1) return 0;
            if (Integer.parseInt("" + s.charAt(i) + s.charAt(i+1)) > 26) return 0;
            
            if (i == s.length() - 2) return 1;

            newI = i + 2;
        }

        int res = rec(s, newI, 1) + rec(s, newI, 2);
        dp[i][variant - 1] = res;
        return res;
    }
}
