class Solution {
    Set<String> words;
    Boolean[] memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        words = new HashSet(wordDict);
        memo = new Boolean[s.length()];
        return rec(0, s);
    }

    private boolean rec(int i, String s) {
        if (i >= s.length()) return true;
        if (memo[i] != null) return memo[i];

        for (int j = i; j < s.length(); j++) {
            if (words.contains(s.substring(i, j + 1))
                && rec(j + 1, s)) {
                    return memo[i] = true;
            }
        }

        return memo[i] = false;
    }
}
