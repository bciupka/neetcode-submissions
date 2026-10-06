class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int max = 0, maxFreq = 0, l = 0, r = 0;

        while (r < s.length()) {
            maxFreq = Math.max(maxFreq, ++freq[s.charAt(r) - 'A']);
            while (r - l + 1 - maxFreq > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }
            max = Math.max(max, r - l + 1);
            r++;
        }
        
        return max;
    }
}
