class Solution {
    public int longestConsecutive(int[] nums) {
       if (nums.length == 0) return 0;
       if (nums.length == 1) return 1;

       Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
       Map<Integer, Integer> seqs = new HashMap<>();

       int curr;
       for (int i = 0; i < nums.length; i++) {
        curr = nums[i];
        if (set.contains(curr + 1) && !set.contains(curr - 1)) {
            seqs.put(curr, 1);
        }
       }

       for (int i : seqs.keySet()) {
        int j = i + 1; 
        while (true) {
            if (set.contains(j)) {
                seqs.put(i, seqs.get(i) + 1);
                j++;
                continue;
            }
            break;
        }
       }

       int max = 1;

       for (int i : seqs.values()) {
        if (i > max) {
            max = i;
        }
       }

       return max;
    }
}
