class Solution {
    char[][] board;
    String word;
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;     
        this.visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtrack(i, j, 0)) return true;
            }
        }

        return false;
    }

    private boolean backtrack(int i, int j, int strI) {
        if (
            i >= board.length
            || i < 0
            || j >= board[0].length
            || j < 0
        ) return false;
        
        int[] currPos = new int[]{i, j};
        if (visited[i][j]) return false;

        char curr = board[i][j];

        if (curr != word.charAt(strI)) return false;

        if (strI == word.length() - 1) {
            return true;
        }

        visited[i][j] = true;
        boolean res = (
            backtrack(i + 1, j, strI + 1)
            || backtrack(i, j+1, strI + 1)
            || backtrack(i - 1, j, strI + 1)
            || backtrack(i, j - 1, strI + 1)
        );
        visited[i][j] = false;

        return res;
    }
}
