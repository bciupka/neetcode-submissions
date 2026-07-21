class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];

        int[][] dp = new int[nums.length][2];
        dp[0] = new int[]{nums[0], nums[0]};
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int max = Math.max(
                Math.max(
                    dp[i-1][0] * nums[i],
                    dp[i-1][1] * nums[i]
                ), 
                nums[i]
            );

            dp[i][0] = max;

            int min = Math.min(
                Math.min(
                    dp[i-1][0] * nums[i],
                    dp[i-1][1] * nums[i]
                ), 
                nums[i]
            );

            dp[i][1] = min;

            res = Math.max(res, max);
        }

        return res;
    }
}
