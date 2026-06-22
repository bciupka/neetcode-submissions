class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int target;
    int[] nums;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        this.target = target;
        this.nums = nums;
        backtrack(0, new LinkedList<Integer>(), 0);
        return res;
    }

    private void backtrack(int i, LinkedList<Integer> curr, int total) {
        if (total == target) {
            res.add((List<Integer>) curr.clone());
            return;
        }
        if (total > target || i >= nums.length) return;

        curr.add(nums[i]);
        backtrack(i, curr, total + nums[i]);
        curr.removeLast();
        backtrack(i + 1, curr, total);
    }
}
