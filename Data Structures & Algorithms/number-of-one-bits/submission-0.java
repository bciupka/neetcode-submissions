class Solution {
    public int hammingWeight(int n) {
        String s = "";
        int res = 0;

        while (n > 0) {
            s = ((n % 2) == 0 ? "0" : "1") + s;
            n = n / 2;
        }

        for (char c : s.toCharArray()) {
            if (c == '1') res++;
        }

        return res; 
    }
}
