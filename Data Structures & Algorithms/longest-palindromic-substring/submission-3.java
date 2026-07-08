class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] check = new boolean[n][n];
        int resI = 0, resJ = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j) && 
                (i - j <= 2 || check[i-1][j+1])) {
                    check[i][j] = true;

                    if (resI - resJ < i - j) {
                        resI = i;
                        resJ = j;
                    }
                }
            }
        }

        return s.substring(resJ, resI + 1);
    }
}
