class Solution {
    private char[][] board;
    private boolean[][] visited;
    private Set<String> res;
    private int ROWS, COLS;

    public List<String> findWords(char[][] board, String[] words) {
        ROWS = board.length;
        COLS = board[0].length;
        this.board = board;
        visited = new boolean[ROWS][COLS];
        res = new HashSet<>();

        Trie trie = new Trie();
        for (String s : words) {
            trie.addWord(s);
        }

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                backtrack(i, j, trie.root, "");
            }
        }

        return new ArrayList<String>(res);
    }

    private void backtrack(int i, int j, TrieNode curr, String word) {
        if (
            i < 0 || j < 0 || i >= ROWS || j >= COLS
            || visited[i][j] || !curr.children.containsKey(board[i][j])
        ) return;

        visited[i][j] = true;
        TrieNode node = curr.children.get(board[i][j]);
        if (node.isWord) {
            res.add(word + board[i][j]);
        }

        backtrack(i + 1, j, node, word + board[i][j]);
        backtrack(i - 1, j, node, word + board[i][j]);
        backtrack(i, j + 1, node, word + board[i][j]);
        backtrack(i, j - 1, node, word + board[i][j]);

        visited[i][j] = false;
    }
}

class TrieNode {
    public Map<Character, TrieNode> children = new HashMap<>();
    public boolean isWord;
}

class Trie {
    public TrieNode root = new TrieNode();

    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
        }

        curr.isWord = true;
    }
}
