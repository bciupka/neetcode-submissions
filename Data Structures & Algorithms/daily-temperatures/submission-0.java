class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures.length == 0) return new int[0];

        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            int cur = temperatures[i];

            while (!stack.isEmpty() && stack.peek()[0] < cur) {
                int[] toSet = stack.pop();
                res[toSet[1]] = i - toSet[1];
            }

            stack.push(new int[]{cur, i});
        }

        return res;
        
    }
}
