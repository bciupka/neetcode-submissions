class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;

        int l, r, amount;
        l = r = 0;
        amount = 26;
        int[] chars = new int[26];
        

        for (; r < s1.length(); r++) {
            char c = s1.charAt(r);
            if (chars[c - 'a'] == 0) amount--;
            chars[c - 'a']++;
            if (chars[c - 'a'] == 0) amount++;

            c = s2.charAt(r);
            if (chars[c - 'a'] == 0) amount--;
            chars[c - 'a']--;
            if (chars[c - 'a'] == 0) amount++;
        }

        if (amount == 26) return true;

        for (; r < s2.length(); r++) {
            char c = s2.charAt(r);
            if (chars[c - 'a'] == 0) amount--;
            chars[c - 'a']--;
            if (chars[c - 'a'] == 0) amount++;

            c = s2.charAt(l++);
            if (chars[c - 'a'] == 0) amount--;
            chars[c - 'a']++;
            if (chars[c - 'a'] == 0) amount++;

            if (amount == 26) return true;
        }

        return false;
        
    }
}
