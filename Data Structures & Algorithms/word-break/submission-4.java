class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n];
        for (int i = n - 1; i >=0; i--) {
            for (String word : wordDict) {
                int m = word.length();
                if (m > n - i) continue;
                if (m == n - i) {
                    dp[i] = s.substring(i).equals(word);
                    if (dp[i]) break;
                    continue;
                } 
                if (s.substring(i).startsWith(word)) {
                    dp[i] = dp[i + m];
                    if (dp[i]) break;
                }
            }
        }

        return dp[0];

        
    }
}
