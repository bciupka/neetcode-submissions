class Solution {
    Trie trie = new Trie();
    Boolean[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        for (String word : wordDict) {
            trie.add(word);
        }
        memo = new Boolean[s.length()];
        return rec(0, s);
    }

    private boolean rec(int i, String s) {
        if (i == s.length()) return true;

        if (memo[i] != null) return memo[i];

        char c = s.charAt(i);

        TrieNode curr = trie.root;
        for (int j = i; j < s.length(); j++) {
            curr = curr.children.get(s.charAt(j));

            if (curr == null) return memo[i] = false;

            if (curr.isEnd) {
                if (rec(j + 1, s)) return memo[i] =  true;
            }
        }

        return memo[i] = false;
    }
}

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEnd;
}

class Trie {
    TrieNode root = new TrieNode();

    public void add(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.isEnd = true;
    }
}
