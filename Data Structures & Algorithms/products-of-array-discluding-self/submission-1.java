class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeros = 0;
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                product *= nums[i];
            } else {
                zeros++;
                if (zeros > 1) {
                    return res;
                }
            }
        }

        if (zeros > 0) {
            for (int i = 0; i < nums.length; i++) {
                    res[i] = nums[i] == 0 ? product : 0;
                } 
            } else {
            for (int i = 0; i < nums.length; i++) {
                res[i] = product / nums[i];
            }
        }
        
        return res;
    }
}  
