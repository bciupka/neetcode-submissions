class PrefixTree {
    public PrefixTreeNode root = new PrefixTreeNode();

    public void insert(String word) {
        PrefixTreeNode curr = root;
        for (char c : word.toCharArray()) {
            PrefixTreeNode next = curr.children.getOrDefault(c, new PrefixTreeNode());
            curr.children.putIfAbsent(c, next);
            curr = next;
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        return scan(word, true);
    }

    public boolean startsWith(String prefix) {
        return scan(prefix, false);
    }

    private boolean scan(String letters, boolean search) {
        PrefixTreeNode curr = root;
        for (char c : letters.toCharArray()) {
            if (!curr.children.containsKey(c)) return false;
            curr = curr.children.get(c);
        }

        if (search) return curr.isEndOfWord;
        return true;
    }
}

class PrefixTreeNode {
    public Map<Character, PrefixTreeNode> children = new HashMap<>();
    public boolean isEndOfWord;
}
