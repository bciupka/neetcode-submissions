class Solution {
    int target;
    int[] nums;
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        this.target = target;
        this.nums = nums;
        Arrays.sort(this.nums);
        backtrack(0, new ArrayList<>(), 0);
        return res;
    }

    private void backtrack(int i, List<Integer> curr, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int j = i; j < nums.length; j++) {
            if (sum + nums[j] > target) return;
            
            curr.add(nums[j]);
            backtrack(j, curr, sum + nums[j]);
            curr.remove(curr.size() - 1);
        }
    }
}
