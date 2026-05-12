class Solution {
    public int[] twoSum(int[] nums, int target) {
       Map<Integer, Integer> map = new HashMap<>(); 

       for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            Integer possibleMatch = map.getOrDefault(difference, null);
            if (possibleMatch != null) {
                return i < possibleMatch ? new int[]{i, possibleMatch} : new int[]{possibleMatch, i};
            }
            map.put(nums[i], i);
       }

       return null;
    }
}
