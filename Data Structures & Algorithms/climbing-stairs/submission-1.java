class Solution {
    int[] cache;

    public int climbStairs(int n) {
        cache = new int[n];
        for (int i = 0; i < n; i++) {
            cache[i] = -1;
        }

        return rec(0, n);

    }

    private int rec(int curr, int n) {
        if (curr > n) return 0;
        if (curr == n) return 1;

        if (cache[curr] == -1) {
            cache[curr] = rec(curr + 1, n) + rec(curr + 2, n);
        }

        return cache[curr];
    }

}
