class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        int i, j;

        for (int m = 0; m < s.length(); m++) {
            i = j = m;
            while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
                res++;
                i--;
                j++;
            }
        }

        
        for (int m = 0; m < s.length(); m++) {
            i = m;
            j = m + 1;
            while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
                res++;
                i--;
                j++;
            }
        }

        return res;
        
    }
}
