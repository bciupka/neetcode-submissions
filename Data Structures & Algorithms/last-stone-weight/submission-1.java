class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        for (int i : stones) {
            heap.offer(i);
        }

        while (heap.size() > 1) {
            int x = heap.poll();
            int y = heap.poll();

            if (y < x) {
                heap.offer(x - y);
            }
        }
        
        heap.offer(0);
        return Math.abs(heap.peek());
    }
}
