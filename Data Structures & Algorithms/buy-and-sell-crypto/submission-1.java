class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;

        int p1 = 0;
        int p2 = 1;
        int maxProfit = 0;

        while (p2 < prices.length) {
            if (prices[p2] < prices[p1]) {
                p1 = p2;
            } else {
                maxProfit = Math.max(maxProfit, prices[p2] - prices[p1]);
            }
            p2++;
        }

        return maxProfit;
    }
}
