class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        backtrack(res, nums, 0, new ArrayList<>());

        return res;
        
    }

    private void backtrack(List<List<Integer>> res, int[] nums, int i, List<Integer> cur) {
        if (i >= nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        cur.add(nums[i]);
        backtrack(res, nums, i + 1, cur);
        cur.remove(cur.size() - 1);
        backtrack(res, nums, i + 1, cur);
    }
}
