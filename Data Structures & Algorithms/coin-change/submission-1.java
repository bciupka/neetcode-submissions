class Solution {
    int min = -1;
    int amount;
    int[] coins;

    public int coinChange(int[] coins, int amount) {
        this.amount = amount;
        this.coins = coins;

        rec(0, 0, 0);
        
        return min;
    }

    private void rec(int i, int currAmount, int currCount) {
        if (i == coins.length) return;
        if (currAmount == amount) {
            if (min == -1 || currCount < min) {
                min = currCount;
                return;
            }
        }

        if (currAmount > amount) return;

        rec(i, currAmount + coins[i], currCount + 1);
        rec(i + 1, currAmount, currCount);
    }
}
