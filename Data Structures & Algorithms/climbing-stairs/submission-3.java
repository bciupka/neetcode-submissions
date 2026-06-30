class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int one = 1, two = 2;
        int res;
        for (int i = 2; i < n; i++) {
            int temp = one;
            one = two;
            two = two + temp;
        }

        return two;
    }
}
