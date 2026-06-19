class WordDictionary {
    private WordDictNode root = new WordDictNode();

    public void addWord(String word) {
        WordDictNode curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new WordDictNode());
            }

            curr = curr.children.get(c);
        }

        curr.isEnd = true;
    }

    public boolean search(String word) {
        return rec(root, word, 0);
    }

    private boolean rec(WordDictNode curr, String word, int i) {
        char currChar = word.charAt(i);
        if (currChar != '.') {
            if (!curr.children.containsKey(currChar)) return false;

            if (i == word.length() - 1) return curr.children.get(currChar).isEnd;

            i++;
            return rec(curr.children.get(currChar), word, i);
        }

        if (i >= word.length() - 1) {
            for (WordDictNode child : curr.children.values()) {
                if (child.isEnd) return true;
            }
            return false;
        }

        i++;
        for (WordDictNode child : curr.children.values()) {
            if (rec(child, word, i)) return true;
        }

        return false;
    }
}

class WordDictNode {
    public Map<Character, WordDictNode> children = new HashMap<>();
    boolean isEnd;
}
