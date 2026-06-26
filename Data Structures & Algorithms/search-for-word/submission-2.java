class Solution {
    private char[][] board;
    private String word;
    private Set<Pos> visited;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.visited = new HashSet<>();

        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[0].length; j++) {
                if (backtrack(i, j, 0)) return true;
            }
        }

        return false;
    }
    
    private boolean backtrack(int i, int j, int strI) {
        if (strI == word.length()) return true;
        Pos curr = new Pos(i, j);
        if (
            i < 0 ||
            j < 0 ||
            i >= board.length ||
            j >= board[0].length ||
            visited.contains(curr) ||
            board[i][j] != word.charAt(strI)
        ) return false;


        visited.add(curr);

        boolean res = (
            backtrack(i + 1, j, strI + 1) ||
            backtrack(i, j + 1, strI + 1) ||
            backtrack(i - 1, j, strI + 1) ||
            backtrack(i, j - 1, strI + 1)
        );

        visited.remove(curr);

        return res;
    }
}

public record Pos(int i, int j) {};
