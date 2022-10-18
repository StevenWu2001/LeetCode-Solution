class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int mod = 1000000007;
        int row = grid.length, col = grid[0].length;
        int[][][] dp = new int[row][col][k];
        dp[0][0][grid[0][0] % k]++;
        
        int sum = grid[0][0];
        for (int i = 1; i < row; i++) {
            sum += grid[i][0];
            dp[i][0][sum % k]++;
        }
        
        sum = grid[0][0];
        for (int j = 1; j < col; j++) {
            sum += grid[0][j];
            dp[0][j][sum % k]++;
        }
        
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                for (int n = 0; n < k; n++) {
                    if (dp[i - 1][j][n] != 0) {
                        dp[i][j][(n + grid[i][j]) % k] += dp[i - 1][j][n];
                        dp[i][j][(n + grid[i][j]) % k] %= mod;
                    }
                    
                    if (dp[i][j - 1][n] != 0) {
                        dp[i][j][(n + grid[i][j]) % k] += dp[i][j - 1][n];
                        dp[i][j][(n + grid[i][j]) % k] %= mod;
                    }
                }
            }
        }
        
        return dp[row - 1][col - 1][0];
    }
}
