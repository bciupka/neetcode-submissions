class Solution {
    int[] nums;
    Map<Integer, Integer> cache;

    public int rob(int[] nums) {
        this.nums = nums;    
        int max = Integer.MIN_VALUE;
        cache = new HashMap<>();
        return dfs(0);
    }

    private int dfs(int curr) {
        if (curr >= nums.length) return 0;

        if (cache.containsKey(curr)) return cache.get(curr);

        int res = Math.max(nums[curr] + dfs(curr + 2), dfs(curr + 1));
        cache.put(curr, res);
        return res;

    }
}
