class Solution {
    public int longestConsecutive(int[] nums) {
       if (nums.length == 0) return 0;
       if (nums.length == 1) return 1;

       Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
       int max = 1;

       int curr;
       for (int i = 0; i < nums.length; i++) {
        curr = nums[i];
        if (set.contains(curr + 1) && !set.contains(curr - 1)) {
            int iter = curr + 1;
            int amount = 1;
            while (true) {
                if (set.contains(iter)) {
                    amount++;
                    iter++;
                    continue;
                }
                if (amount > max) {
                    max = amount;
                }
                break;
            }
        }
       }

       return max;
    }
}
