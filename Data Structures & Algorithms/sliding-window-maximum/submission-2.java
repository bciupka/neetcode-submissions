class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int l, r;
        l = r = 0;
        Queue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        while (r < nums.length) {
            heap.offer(new int[]{nums[r], r});
            
            if (r + 1 >= k) {
                while (heap.peek()[1] < l) {
                    heap.poll();
                }

                res[l] = heap.peek()[0];
                l++;
            }

            r++;
        }

        return res;
    }
}
