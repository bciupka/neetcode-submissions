class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        
        int one, two;
        one = nums[0];
        two = Math.max(nums[1], one);

        for (int i = 2; i < nums.length; i++) {
            int temp = one;
            one = two;
            two = Math.max(two, temp + nums[i]);
        }

        return two;
        
    }
}
