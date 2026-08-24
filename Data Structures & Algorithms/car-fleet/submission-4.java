class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] posSpd = new int[n][2];

        for (int i = 0; i < n; i++) {
            posSpd[i] = new int[]{position[i], speed[i]};
        }

        Arrays.sort(posSpd, (a, b) -> b[0] - a[0]);

        // Arrays.stream(posSpd).forEach(a -> System.out.println(Arrays.toString(a)));

        Stack<Double> stack = new Stack<>();
        for (int[] cur : posSpd) {
            double curTime = (target - cur[0]) / (double) cur[1];
            stack.push(curTime);
            if (stack.size() > 1
                && stack.peek() <= stack.get(stack.size() - 2)) {
                    stack.pop();
                }
        }
        
        return stack.size();
    }
}
