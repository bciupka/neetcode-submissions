class Solution {
    final int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        final int ROWS = heights.length;
        final int COLS = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();
        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];

        for (int r = 0; r < ROWS; r++) {
            dfs(r, 0, pac, heights);
            dfs(r, COLS - 1, atl, heights);
        }

        for (int c = 0; c < COLS; c++) {
            dfs(0, c, pac, heights);
            dfs(ROWS - 1, c, atl, heights);
        }

        for (int i = 0; i < ROWS;  i++) {
            for (int j = 0; j < COLS; j++) {
                if (pac[i][j] && atl[i][j]) {
                    res.add(List.of(i, j));
                }
            }
        }

        return res;
    }

    private void dfs(int r, int c, boolean[][] ocean, int[][] heights) {
        ocean[r][c] = true; 
        for (int[] dir : dirs) {
            int nr = r + dir[0], nc = c + dir[1];
            if (nr >= 0 && nr < heights.length
                && nc >= 0 && nc < heights[0].length
                && !ocean[nr][nc]
                && heights[nr][nc] >= heights[r][c]) {
                    dfs(nr, nc, ocean, heights);
                }
        }
    }
}
