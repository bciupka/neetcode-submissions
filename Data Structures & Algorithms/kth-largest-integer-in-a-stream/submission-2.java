class KthLargest {
    Queue<Integer> heap;
    int k;

    public KthLargest(int k, int[] nums) {
        heap = new PriorityQueue<>(Arrays.stream(nums).boxed().toList());
        while (heap.size() - k > 0) {
            heap.poll();
        }
        this.k = k;
    }
    
    public int add(int val) {
        heap.offer(val);
        if (heap.size() > k) {
            heap.poll();
        }
        return heap.peek();
    }
}
