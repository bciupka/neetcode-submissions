class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];

        int l = 0, r = nums.length - 1;


        while (l < r) {
            if (nums[l] < nums[r]) {
                break;
            }

            int mid = (l + r) / 2;
            if (nums[mid] < nums[l]) {
                r = mid;
            } else {
                l = mid + 1;
            }

        }

        return nums[l];
    }
}
