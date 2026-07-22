class Solution {
    public int maxProduct(int[] nums) {
        int max, min, res;
        max = min = res = nums[0];


        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(
                Math.max(nums[i] * max, 
                        nums[i] * min),
                nums[i]
            );

            min = Math.min(
                Math.min(nums[i] * temp, 
                        nums[i] * min),
                nums[i]
            );

            res = Math.max(res, max);
        }
        
        return res;
    }
}
