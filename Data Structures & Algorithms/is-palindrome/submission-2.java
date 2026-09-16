class Solution {
    public boolean isPalindrome(String s) {
        int l, r;
        String sl = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (char c : sl.toCharArray()) {
            if (Character.isDigit(c) || Character.isLetter(c)) {
                sb.append(c);
            }
        }
        String sf = sb.toString();
        if (sf.length() == 0) return true;

        if (sf.length() % 2 != 0) {
            l = r = sf.length() / 2;
        } else {
            l = sf.length() / 2 - 1;
            r = l + 1;
        }


        while (l >= 0) {
            if (sf.charAt(l--) != sf.charAt(r++)) return false;
        }

        return true;
    }
}
