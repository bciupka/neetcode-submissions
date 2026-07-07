class Solution {
    String longest;
    String s;
    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        longest = "";
        this.s = s; 
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j > 0; j--) {
                palCheck(i, j);
            }
        }

        return longest;
    }

    private void palCheck(int l, int r) {
        int length = r - l + 1;
        if (length <= longest.length()) return;
        String temp = s.substring(l, r + 1);
        while (l <= r) {
            if (s.charAt(l++) != s.charAt(r--)) return; 
        }

        longest = temp;
    }
}
