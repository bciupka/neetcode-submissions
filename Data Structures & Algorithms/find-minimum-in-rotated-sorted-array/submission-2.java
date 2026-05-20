class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];

        int l = 0, r = nums.length - 1, res = nums[0];


        while (l <= r) {

            if (nums[l] < nums[r]) {
                res = Math.min(res, nums[l]);
                break;
            }
            int mid = (l + r) / 2;
            res = Math.min(res, nums[mid]);

            if (nums[mid] < nums[l]) {
                r = mid;
            } else {
                l = mid + 1;
            }


        }

        return res;
    }
}
