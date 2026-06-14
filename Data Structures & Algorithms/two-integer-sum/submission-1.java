class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> lookup = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (lookup.containsKey(diff)) {
                return new int[]{lookup.get(diff), i};
            }

            lookup.put(nums[i], i);
        }
        
        return new int[2];
    }
}
