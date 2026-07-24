class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int prefix = 0;
        int suffix = 0;
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            prefix = nums[i] * (prefix == 0 ? 1 : prefix); 
            suffix = nums[n - 1 - i] * (suffix == 0 ? 1 : suffix); 
            int max = Math.max(prefix, suffix);
            res = Math.max(max, res);
        }

        return res;

    }
}
