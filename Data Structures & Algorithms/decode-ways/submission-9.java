class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int one = 1;
        int two = s.charAt(n - 1) == '0' ? 0 : 1;

        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                one = two;
                two = 0;
                continue;
            }

            int temp = one;
            one = two;

            if (check(s, i)) {
                two += temp;
            }
        }

        return two;
    }

    private boolean check(String s, int i) {
        int n = s.length();
        if (i + 1 < n) {
            if (Integer.parseInt("" + s.charAt(i) + s.charAt(i+1)) > 9
                && Integer.parseInt("" + s.charAt(i) + s.charAt(i+1)) < 27) {
                    return true;
                }
        }

        return false;
    }
}
