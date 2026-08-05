class Solution {
    Set<String> visited;
    char[][] grid;
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int amount = 0;
        visited = new HashSet<>();
        this.grid = grid;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited.contains(i + ":" + j) && grid[i][j] == '1') {
                    bfs(i, j);
                    amount++;
                }
            }
        }

        return amount;
    }

    private void bfs(int r, int c) {
        Deque<int[]> deque = new LinkedList<>();
        deque.add(new int[]{r, c});
        visited.add(r  + ":" + c);

        List<int[]> dirs = List.of(
            new int[]{0, 1},
            new int[]{1, 0},
            new int[]{-1, 0},
            new int[]{0, -1}
        );

        while (!deque.isEmpty()) {
            int[] curr = deque.poll();
            for (int[] dir : dirs) {
                int currR = curr[0] + dir[0], currC = curr[1] + dir[1];
                String currKey = currR + ":" + currC;
                if (!visited.contains(currKey) &&
                    currR >= 0 &&
                    currC >= 0 &&
                    currR < grid.length &&
                    currC < grid[0].length &&
                    grid[currR][currC] == '1'
                    ) {
                        visited.add(currKey);
                        deque.add(new int[]{currR, currC});
                    }
            };
        }
    }
}
