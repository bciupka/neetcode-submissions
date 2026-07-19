class Solution {
    int[] coins;
    int[] dp;
    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        dp = new int[amount + 1];
        return rec(amount);
    }

    private int rec(int remainingAmount) {
        if (remainingAmount == 0) return 0;
        if (remainingAmount < 0) return -1;
        if (dp[remainingAmount] != 0) return dp[remainingAmount];

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int temp = rec(remainingAmount - coin);
            if (temp == -1) continue;
            res = Math.min(res, temp + 1);
        }

        res = res == Integer.MAX_VALUE ? -1 : res; 
        dp[remainingAmount] = res;
        return res;
    }
}
