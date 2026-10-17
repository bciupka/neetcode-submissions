class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;
        int l, r, amount;
        l = r = amount = 0;
        int[] map1 = new int[26];
        int[] map2 = new int[26];

        for (; r < s1.length(); r++) {
            char c1 = s1.charAt(r);
            char c2 = s2.charAt(r);
            map1[c1 - 'a']++;
            map2[c2 - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (map1[i] == map2[i]) amount++;
        }

        if (amount == 26) return true;

        for (; r < s2.length(); r++) {
            char cR = s2.charAt(r);
            char cL = s2.charAt(l);
            if (map2[cR - 'a'] == map1[cR - 'a']) amount--;
            map2[cR - 'a']++;
            if (map2[cR - 'a'] == map1[cR - 'a']) amount++;

            if (map2[cL - 'a'] == map1[cL - 'a']) amount--;
            map2[cL - 'a']--;
            if (map2[cL - 'a'] == map1[cL - 'a']) amount++;

            if (amount == 26) return true;
            l++;
        }

        return false;
        
    }
}
