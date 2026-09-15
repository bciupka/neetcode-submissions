class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '('
                || c == '['
                || c == '{') {
                stack.add(c);
            } else {
                if (stack.isEmpty()) return false;
                char cur = stack.pop();
                if (c - cur < 1
                    || c - cur > 2) return false;
            }
        }


        return stack.isEmpty();
    }
}
