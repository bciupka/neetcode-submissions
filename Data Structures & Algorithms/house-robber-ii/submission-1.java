class Solution {
    private Map<Integer, Integer> cache;

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        
        this.cache = new HashMap<>();
        int res1 = rec(0, Arrays.copyOfRange(nums, 0, nums.length - 1));
        this.cache = new HashMap<>();
        int res2 = rec(0, Arrays.copyOfRange(nums, 1, nums.length)); 
        return Math.max(res1, res2);
                        
    }

    private int rec(int i, int[] nums) {
        if (i >= nums.length) return 0;
        if (cache.containsKey(i)) return cache.get(i);

        int res = Math.max(
            nums[i] + rec(i + 2, nums),
            rec(i + 1, nums)
            );

        cache.put(i, res);
        return res;
    }
}
