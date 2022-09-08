// Time: O(N)
// Space: O(1)

class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int curMin = prices[0];
        
        for (int i = 0; i < prices.length; i++) {
            curMin = Math.min(curMin, prices[i]);
            profit = Math.max(profit, prices[i] - curMin);
        }
        
        return profit;
    }
}
