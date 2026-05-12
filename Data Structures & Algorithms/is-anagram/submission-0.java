class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        s = s.toLowerCase();
        t = t.toLowerCase();
        
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (Character i : s.toCharArray()) {
            map1.put(i, map1.getOrDefault(i, 0) + 1);
        }

        for (Character i : t.toCharArray()) {
            map2.put(i, map2.getOrDefault(i, 0) + 1);
        }

        return map1.equals(map2);
    }
}
