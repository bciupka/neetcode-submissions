class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       Map<Integer, Integer> counts = new HashMap<>();
       for (int i : nums) {
        counts.put(i, counts.getOrDefault(i, 0) + 1);
       }

       Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);

       for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
        queue.offer(new int[]{entry.getValue(), entry.getKey()});
        if (queue.size() > k) {
            queue.poll();
        }
       }

       int[] res = new int[k];

       for (int i = 0; i < k; i++) {
        res[i] = queue.poll()[1];
       }

       return res;
    }
}
