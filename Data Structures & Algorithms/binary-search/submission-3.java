class Solution {
    public int search(int[] nums, int target) {
        int l, r;
        l = 0;
        r = nums.length - 1;

        while (l <= r) {
            int m = (r + l) / 2;
            int mVal = nums[m];

            if (mVal == target) return m;
            if (mVal < target) {
                l = m + 1;
                continue;
            }
            r = m - 1;
        }

        return -1;
    }
}
