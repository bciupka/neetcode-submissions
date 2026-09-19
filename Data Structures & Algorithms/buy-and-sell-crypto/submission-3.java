class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;

        int res = 0;
        int l, r;
        l = 0;
        r = l + 1;

        while (r < prices.length) {
            if (prices[r] < prices[l]) {
                l = r++;
                continue;
            }
            res = Math.max(res, prices[r] - prices[l]);
            r++;
        }

        return res;
    }
}
