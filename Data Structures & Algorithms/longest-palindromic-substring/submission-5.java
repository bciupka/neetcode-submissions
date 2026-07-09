class Solution {
    public String longestPalindrome(String s) {
        int resI = 0, resJ = 0;
        int i, j;

        for (int m = 0; m < s.length(); m++) {
            i = j = m;
            while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
                if (resJ - resI < j - i) {
                    resI = i;
                    resJ = j;
                }
                i--;
                j++;
            }
        }
        

        for (int m = 0; m < s.length(); m++) {
            i = m;
            j = m + 1;
            while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
                if (resJ - resI < j - i) {
                    resI = i;
                    resJ = j;
                }
                i--;
                j++;
            }
        }

        return s.substring(resI, resJ + 1);
    }

}
