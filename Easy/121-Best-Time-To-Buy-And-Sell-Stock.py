class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        curr_lowest, max_profit = prices[0], 0

        for i, v in enumerate(prices):
            if i == 0:
                continue
            
            max_profit = max(max_profit, v - curr_lowest)
            curr_lowest = min(curr_lowest, v)
                
        return max_profit
