class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int l, r;
        l = r = 0;
        Deque<Integer> q = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];

        while (r < nums.length) {
            while (!q.isEmpty() && nums[q.peekLast()] < nums[r]) {
                q.pollLast();
            }
            q.offerLast(r);

            if (l > q.peekFirst()) {
                q.pollFirst();
            }

            if ((r + 1) >= k) {
                res[l++] = nums[q.peekFirst()];
            }
            r++;
        }
        
        return res;
    }
}
