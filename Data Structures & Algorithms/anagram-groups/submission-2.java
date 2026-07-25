class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();

        for (String s : strs) {
            int[] fingerprint = new int[26];
            for (char c : s.toCharArray()) {
                fingerprint[c - 'a']++;
            }
            String fpString = Arrays.toString(fingerprint);
            List<String> currList = res.getOrDefault(fpString, new ArrayList<>());
            currList.add(s);
            res.put(fpString, currList);
        }


        List<List<String>> resList = new ArrayList<>();
        for (List<String> vals : res.values()) {
            resList.add(vals);
        }
        
        return resList;
    }
}
