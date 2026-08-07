class Solution {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, { 0, -1}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int islands = 0;
        int r = grid.length, c = grid[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    dfs(i, j, grid);
                }
            }
        }
        
        return islands;
    }

    private void dfs(int r, int c, char[][] grid) {
        Deque<int[]> stack = new LinkedList<>();
        stack.push(new int[]{r, c});
        grid[r][c] = '0';

        while (!stack.isEmpty()) {
            int[] curr = stack.pop();

            for (int[] dir : dirs) {
                int currR = curr[0] + dir[0], currC = curr[1] + dir[1];
                if (
                    currR >= 0 && currR < grid.length
                    && currC >= 0 && currC < grid[0].length
                    && grid[currR][currC] =='1'
                ) {
                    stack.push(new int[]{currR, currC});
                    grid[currR][currC] = '0';
                }
            }
        }

    }
}
