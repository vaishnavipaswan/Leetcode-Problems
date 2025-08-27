class Solution {
    private static final int[] d = {1, 1, -1, -1, 1}; // (1,1), (1,-1), (-1,-1), (-1,1)
    private int[][][][] dp;
    private int n, m;

    private boolean isOutOfBounds(int i, int j) {
        return i < 0 || i >= n || j < 0 || j >= m;
    }

    private int dfs(int i, int j, int dir, int turn, int nxt, int[][] grid) {
        if (dp[i][j][dir][turn] != -1) return dp[i][j][dir][turn];

        int ans = 1;
        int s = i + d[dir], t = j + d[dir + 1];
        if (!isOutOfBounds(s, t) && grid[s][t] == nxt)
            ans = Math.max(ans, 1 + dfs(s, t, dir, turn, nxt ^ 2, grid));

        if (turn == 0) {
            int newDir = (dir + 1) & 3;
            int u = i + d[newDir], v = j + d[newDir + 1];
            if (!isOutOfBounds(u, v) && grid[u][v] == nxt)
                ans = Math.max(ans, 1 + dfs(u, v, newDir, 1, nxt ^ 2, grid));
        }

        return dp[i][j][dir][turn] = ans;
    }

    public int lenOfVDiagonal(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        dp = new int[n][m][4][2];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                for (int d = 0; d < 4; d++)
                    for (int t = 0; t < 2; t++)
                        dp[i][j][d][t] = -1;

        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == 1)
                    for (int dir = 0; dir < 4; dir++)
                        ans = Math.max(ans, dfs(i, j, dir, 0, 2, grid));

        return ans;
    }
}