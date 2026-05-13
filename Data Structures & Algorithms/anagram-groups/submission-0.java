class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       List<List<String>> result = new ArrayList<>();
       String[] sortedStrs = new String[strs.length];
       Map<String, List<String>> groups = new HashMap<>();
       
       for (int i = 0; i < strs.length; i++)  {
        char[] chars = strs[i].toCharArray();
        Arrays.sort(chars);
        String sortedStr = new String(chars);
        sortedStrs[i] = sortedStr;
       }

       for (int i = 0; i < strs.length; i++)  {
        List<String> possibleListOfAnagrams = groups.getOrDefault(sortedStrs[i], new ArrayList<>());
        possibleListOfAnagrams.add(strs[i]);
        groups.put(sortedStrs[i], possibleListOfAnagrams);
       }

       for (List<String> ls : groups.values()) {
        result.add(ls);
       }
       

       return result;
    }
}
