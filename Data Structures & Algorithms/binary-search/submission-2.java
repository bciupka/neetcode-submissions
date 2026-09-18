class Solution {
    public int search(int[] nums, int target) {
        int l, r; 
        l = 0;
        r = nums.length - 1;


        int m;
        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] == target) return m;
            if (nums[m] < target) {
                l = m + 1;
                continue;
            }
            r = m - 1;
        }

        return -1;
    }
}
