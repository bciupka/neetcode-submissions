class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(
            singleRob(nums, 0, nums.length - 1),
            singleRob(nums, 1, nums.length));
    }

    private int singleRob(int[] nums, int l, int r) {
        if (r - l <= 1) return nums[l];
        int one, two;
        one = nums[l];
        two = Math.max(one, nums[l + 1]);

        for (int i = l + 2; i < r; i++) {
            int temp = one;
            one = two;
            two = Math.max(temp + nums[i], one);
        }

        return two;
    }
}
