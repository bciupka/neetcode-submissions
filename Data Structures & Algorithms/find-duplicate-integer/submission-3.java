class Solution {
    public int findDuplicate(int[] nums) {
        for (int num : nums) {
            int ind = Math.abs(num);
            if (nums[ind] < 0) {
                return ind;
            }

            nums[ind] *= -1;
        }
        
        return -1;
    }
}
