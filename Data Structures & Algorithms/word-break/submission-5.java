class Solution {
    Boolean[] memo;
    List<String> wordDict;
    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new Boolean[s.length()];
        this.wordDict = wordDict;
        
        return rec(0, s);
    }

    private boolean rec(int i, String s) {
        int n = s.length();
        if (i >= n) return true;
        if (memo[i] != null) return memo[i];

        for (String w : wordDict) {
            if (s.substring(i).startsWith(w) &&
                rec(i + w.length(), s)) {
                return memo[i] = true;
            }
        }

        return memo[i] = false;
    }
}
