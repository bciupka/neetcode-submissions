class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       Map<Integer, Integer> counts = new HashMap<>(); 
       for (int i : nums) {
        Integer current = counts.getOrDefault(i, 0);
        current++;
        counts.put(i, current);
       }
       
       List<Integer>[] freq = new ArrayList[nums.length];
       for (int i = 0; i < nums.length; i++) {
        freq[i] = new ArrayList<>();
       }

       for (Integer key : counts.keySet()) {
        freq[counts.get(key) - 1].add(key);
       }

       int[] result = new int[k];

       for (int i = nums.length - 1; i >=0; i--) {
        List<Integer> curr = freq[i];
        for (Integer el : curr) {
            if (k > 0) {
                result[result.length - k] = el;
                k--;
            }
        }
       }

    return result;

    }
}
