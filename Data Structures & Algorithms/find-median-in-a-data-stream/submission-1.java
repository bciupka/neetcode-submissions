class MedianFinder {
    Queue<Integer> minHeap;
    Queue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>(); 
        maxHeap = new PriorityQueue<>((a, b) -> b - a); 
    }
    
    public void addNum(int num) {
        if (maxHeap.size() == 0 || num < maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.offer(maxHeap.poll());
        }

        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        System.out.println(maxHeap);
        System.out.println(minHeap);
        if (maxHeap.size() - minHeap.size() == 0) {
            return (1.0 * minHeap.peek() + 1.0 * maxHeap.peek()) / 2.0;
        }

        if (maxHeap.size() > minHeap.size()) {
            return (double) maxHeap.peek();
        }

        return (double) minHeap.peek();
    }
}
