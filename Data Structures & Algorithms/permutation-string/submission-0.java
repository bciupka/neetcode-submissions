class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l, r, amount; 
        l = r = 0;
        amount = s1.length();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }


        while (r < s2.length()) {
            char rChar = s2.charAt(r);

            if (map.containsKey(rChar)) {
                if (map.get(rChar) > 0) {
                    amount--;
                    if (amount == 0) return true;
                    map.put(rChar, map.get(rChar) - 1);
                    r++;
                    continue;
                }

                while (l < r) {
                    char lChar = s2.charAt(l);
                    if (lChar != rChar) {
                        map.put(lChar, map.get(lChar) + 1);
                        amount++;
                        l++;
                    } else {
                        l++;
                        break;
                    }
                }
                r++;

            } else {
                if (l == r) {
                    l++;
                    r++;
                    continue;
                }
                
                while (l < r) {
                    char lChar = s2.charAt(l);
                    map.put(lChar, map.get(lChar) + 1);
                    amount++;
                    l++;
                }
            }
        }

        return false;
    }
}
