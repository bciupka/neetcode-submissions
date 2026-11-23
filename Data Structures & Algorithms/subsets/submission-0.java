class Solution {
    private List<List<Integer>> res;
    private int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        res = new ArrayList<>();

        rec(0, new ArrayList<Integer>());

        return res;
    }

    private void rec(int i, List<Integer> cur) {
        if (i >= nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        cur.add(nums[i]);
        rec(i + 1, cur);
        cur.remove(cur.size() - 1);
        rec(i + 1, cur);
    }

}
