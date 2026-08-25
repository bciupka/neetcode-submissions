class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int n = heights.length;
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int index = i;
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] pair = stack.pop();
                maxArea = Math.max(maxArea, (i - pair[0]) * pair[1]);
                index = pair[0];
            }
            stack.push(new int[]{index, heights[i]});
        }

        while (!stack.isEmpty()) {
            int[] pair = stack.pop();
            maxArea = Math.max(maxArea, (n - pair[0]) * pair[1]);
        }
        
        return maxArea;
    }
}
