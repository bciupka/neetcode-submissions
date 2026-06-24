class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length, m;

        while (l < r) {
            m = (l + r) / 2;
            if (target == nums[m]) return m;

            if (target > nums[m]) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return -1;
        
    }
}
