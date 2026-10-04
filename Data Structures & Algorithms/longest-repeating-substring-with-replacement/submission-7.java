class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freq = new HashMap<>();
        int max = 0, l = 0, r = 0;

        while (r < s.length()) {
            freq.put(s.charAt(r), freq.getOrDefault(s.charAt(r), 0) + 1);
            while ((r - l + 1) - freq.values().stream().mapToInt(Integer::intValue).max().orElse(0)  > k) {
                freq.put(s.charAt(l), freq.get(s.charAt(l)) - 1);
                l++;
            }
            max = Math.max(max, r - l + 1);
            r++;
        }

        return max;
    }
}
