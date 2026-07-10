class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] check = new boolean[n][n];
        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || check[i-1][j+1])) {
                    check[i][j] = true;
                    res++;
                }
            }
        }

        return res;
        
    }
}
