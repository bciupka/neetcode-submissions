class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        int l, r;
        l = r = 0;
        int[] res = new int[nums.length - k + 1];

        for (; r < k; r++) {
            heap.offer(nums[r]);
        }

        res[0] = heap.peek();

        for (; r < nums.length; r++) {
            heap.remove(nums[l++]);
            heap.offer(nums[r]);
            res[l] = heap.peek();
        }
        
        return res;
    }
}
