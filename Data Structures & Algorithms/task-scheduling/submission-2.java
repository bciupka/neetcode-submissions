class Solution {
    public int leastInterval(char[] tasks, int n) {
        Queue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> q = new LinkedList<>();
        int[] counts = new int[26];
        int time = 0;

        for (char c : tasks) {
            counts[c - 'A']++;
        }

        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0) {
                heap.offer(counts[i]);
            }
        }

        while (!heap.isEmpty() || !q.isEmpty()) {
            time++;

            if (!heap.isEmpty()) {
                int cur = heap.poll();
                cur--;
                if (cur != 0) {
                    q.add(new int[]{cur, time + n});
                }
            } else {
                time = q.peek()[1];
            }

            if (!q.isEmpty() && q.peek()[1] <= time) {
                heap.offer(q.poll()[0]);
            }
        }

        return time;
    }
}
