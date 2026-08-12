class Solution {
    private final int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        final int ROWS = heights.length;
        final int COLS = heights[0].length;

        Set<List<Integer>> pacificAccess = new HashSet<>();
        Set<List<Integer>> atlanticAccess = new HashSet<>();

        for (int r = 0; r < ROWS; r++) {
            dfs(r, 0, pacificAccess, heights);
            dfs(r, COLS - 1, atlanticAccess, heights);
        }

        for (int c = 0; c < COLS; c++) {
            dfs(0, c, pacificAccess, heights);
            dfs(ROWS - 1, c, atlanticAccess, heights);
        }
        
        pacificAccess.retainAll(atlanticAccess);
        return new ArrayList(pacificAccess);
    }

    private void dfs(int r, int c, Set<List<Integer>> hasAccess, int[][] heights) {
        hasAccess.add(List.of(r, c));
        for (int[] dir : dirs) {
            int nr = r + dir[0], nc = c + dir[1];
            if (nr >= 0 && nr < heights.length
                && nc >= 0 && nc < heights[0].length
                && !hasAccess.contains(List.of(nr, nc))
                && heights[r][c] <= heights[nr][nc]) {
                    dfs(nr, nc, hasAccess, heights);
                }
        }
    }
}
