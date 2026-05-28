class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;

        int res = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                res = Math.max(prices[j] - prices[i], res);
            }
        }

        return Math.max(0, res);
    }
}
