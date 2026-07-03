class Solution {
    private Map<Integer, Integer> cache;
    private int[] nums;

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        this.nums = nums;
        this.cache = new HashMap<>();
        int res1 = rec(0, nums.length - 1);
        this.cache = new HashMap<>();
        int res2 = rec(1, nums.length); 
        return Math.max(res1, res2);
                        
    }

    private int rec(int i, int j) {
        if (i >= j) return 0;
        if (cache.containsKey(i)) return cache.get(i);

        int res = Math.max(
            nums[i] + rec(i + 2, j),
            rec(i + 1, j)
            );

        cache.put(i, res);
        return res;
    }
}
