// 2D Dynamic Programming Solution

class Solution {
    public boolean hasValidPath(char[][] grid) {
        int row = grid.length, col = grid[0].length;
        
        if (grid[0][0] == ')' || grid[row - 1][col - 1] == '(' || (row + col - 1) % 2 != 0) {
            return false;
        }
        
        int[][][] dp = new int[row + 1][col + 1][200];
        dp[1][1][1] = 1;
        
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                for (int k = 0; k < 200; k++) {
                    if (grid[i - 1][j - 1] == '(') {
                        if (dp[i - 1][j][k] > 0 || dp[i][j - 1][k] > 0) {
                            dp[i][j][k + 1]++;
                        }
                    } else {
                        if ((dp[i - 1][j][k] > 0 || dp[i][j - 1][k] > 0) && k > 0) {
                            dp[i][j][k - 1]++;         
                        }
                    }
                }
            }
        }
        return dp[row][col][0] > 0;
    }
}
