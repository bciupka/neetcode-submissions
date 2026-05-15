class Solution {

    public String encode(List<String> strs) {
        StringBuilder strBuilder = new StringBuilder();

        for (String s : strs) {
        strBuilder.append(s.length() + "#" + s);
        }

        return new String(strBuilder);
    }

    public List<String> decode(String str) {
        int currIndex = 0;
        List<String> finalArray = new ArrayList<>();

        while (str.length() > currIndex) {
            int nextHash = str.substring(currIndex).indexOf('#') + currIndex;
            int amount = Integer.parseInt(str.substring(currIndex, nextHash));
            currIndex = nextHash + 1;
            finalArray.add(str.substring(currIndex, currIndex + amount));
            currIndex += amount;
        }

        return finalArray;
    }
}
