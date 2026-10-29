class KthLargest {
    private Queue<Integer> heap;
    private int k;

    public KthLargest(int k, int[] nums) {
        heap = new PriorityQueue<>((a, b) -> b - a);
        this.k = k; 
        for (int n : nums) {
            heap.offer(n);
        }
    }
    
    public int add(int val) {
        heap.offer(val);
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = heap.poll();
        }

        for (int i = 0; i < k; i++) {
            heap.offer(temp[i]);
        }

        return temp[k - 1];
    }
}
