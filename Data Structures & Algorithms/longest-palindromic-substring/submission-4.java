class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        int resI = 0, resJ = 0;
        int m = 0, i = 0, j = 0;
        while (m < s.length()) {
            if (i < 0 || j >= s.length()) {
                m++;
                i = j = m;
                continue;
            }

            if (s.charAt(i) == s.charAt(j)) {
                if (resJ - resI < j - i) {
                    resI = i;
                    resJ = j;
                }
                i--;
                j++;
            } else {
                m++;
                i = j = m;
                continue;
            }
        }
        m = 0;
        i = 0;
        j = 1;
        while (m < s.length()) {
            if (i < 0 || j >= s.length()) {
                m++;
                i = m;
                j = m + 1;
                continue;
            }

            if (s.charAt(i) == s.charAt(j)) {
                if (resJ - resI < j - i) {
                    resI = i;
                    resJ = j;
                }
                i--;
                j++;
            } else {
                m++;
                i = m;
                j = m + 1;
                continue;
            }
        }

        return s.substring(resI, resJ + 1);
        
    }
}
