class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = Arrays.stream(piles).max().orElse(-1);
        int res = Integer.MAX_VALUE;

        while (min <= max) {
            int m = (min + max) / 2;
            int amount = calcH(m, piles);
            if (amount <= h) {
                res = Math.min(res, m);
                max = m - 1;
                continue;
            }
            if (amount > h) {
                min = m + 1;
            }
        }

        return res;
    }

    private int calcH(int rate, int[] piles) {
        int res = 0;
        for (int cur : piles) {
            res += cur / rate;
            if (cur % rate !=0) res++;
        }

        return res;
    }
}
