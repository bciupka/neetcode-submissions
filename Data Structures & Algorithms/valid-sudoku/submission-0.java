class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<String, boolean[]> seen = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;

                String rowStr = "r" + i;
                String colStr = "c" + j;
                String squareStr = "s" + (i / 3) + (j / 3);
                seen.putIfAbsent(rowStr, new boolean[9]);
                seen.putIfAbsent(colStr, new boolean[9]);
                seen.putIfAbsent(squareStr, new boolean[9]);
                boolean[] rowSeen = seen.get(rowStr);
                boolean[] colSeen = seen.get(colStr);
                boolean[] squareSeen = seen.get(squareStr);
                
                if (rowSeen[board[i][j] - '1']
                    || colSeen[board[i][j] - '1']
                    || squareSeen[board[i][j] - '1']) {
                        return false;
                } else {
                    rowSeen[board[i][j] - '1'] = true;
                    colSeen[board[i][j] - '1'] = true;
                    squareSeen[board[i][j] - '1'] = true;
                }
            }
        }
        
        return true;
    }
}
