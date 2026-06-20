class WordDictionary {
    WordDictNode root = new WordDictNode();

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
        return dfs(0, root, word);
    }

    private boolean dfs(int j, WordDictNode root, String word) {
        WordDictNode curr = root;
        for (int i = j; i < word.length(); i++) {
            if (word.charAt(i) == '.') {
                for (WordDictNode child : curr.children.values()) {
                    if (dfs(i + 1, child, word)) return true;
                }
                return false;
            } else {
                if (!curr.children.containsKey(word.charAt(i))) return false;

                curr = curr.children.get(word.charAt(i));
            }
        }
        
        return curr.isEnd;
    }
}

class WordDictNode {
    public Map<Character, WordDictNode> children = new HashMap<>();
    boolean isEnd;
}