// Time: O(N)
// Space: O(1)

class Solution {
    public int titleToNumber(String columnTitle) {
        int ans = 0;
        int base = 0;
        
        for (int i = columnTitle.length() - 1; i >= 0; --i) {
            ans += (columnTitle.charAt(i) - 64) * (int)(Math.pow(26, base++));
        }
        
        return ans;
    }
}
