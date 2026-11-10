class Solution {
    public int leastInterval(char[] tasks, int n) {
        int time = 0;
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        Deque<int[]> q = new ArrayDeque<>();
        Map<Character, Integer> map = new HashMap<>();

        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i : map.values()) {
            heap.offer(i);
        }

        while (!heap.isEmpty() || !q.isEmpty()) {
            time++;
            if (!heap.isEmpty()) {
                int cur = heap.poll();
                cur--;
                if (cur > 0) {
                    q.addLast(new int[]{cur, time + n});
                }
            }

            if (!q.isEmpty() && q.peekFirst()[1] <= time) {
                heap.offer(q.pollFirst()[0]);
            }
        }
        
        return time;
        
    }
}
