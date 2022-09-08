// Time: O(N)
// Space: O(1)
// An improved version of dp. Uses fibonacci sequence

class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        
        int first = 1, second = 1;
        int ans = 0;
        
        for (int i = 0; i < n - 1; i++) {
            ans = first + second;
            first = second;
            second = ans;
        }
        
        return ans;
    }
}
