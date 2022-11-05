// State Machine Solution

class Solution {
    public int maxProfit(int[] prices) {
        int[] noStock = new int[prices.length];
        int[] inHand = new int[prices.length];
        int[] sold = new int[prices.length];
        inHand[0] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            noStock[i] = Math.max(noStock[i - 1], sold[i - 1]);
            inHand[i] = Math.max(inHand[i - 1], noStock[i - 1] - prices[i]);
            sold[i] = inHand[i - 1] + prices[i];
        }

        return Math.max(sold[prices.length - 1], noStock[prices.length - 1]);
    }

}

// DP solution with caching
class Solution {
    
    Map<Integer, Integer> buyProfit = new HashMap<>(), sellProfit = new HashMap<>();

    public int maxProfit(int[] prices) {
        return helper(0, true, prices);
    }

    public int helper(int idx, boolean buying, int[] prices) {
        if (idx >= prices.length) {
            return 0;
        } else if (buying && buyProfit.containsKey(idx)) {
            return buyProfit.get(idx);
        } else if (!buying && sellProfit.containsKey(idx)) {
            return sellProfit.get(idx);
        }

        if (buying) {
            int buy = helper(idx + 1, !buying, prices) - prices[idx];
            int cd = helper(idx + 1, buying, prices);
            buyProfit.put(idx, Math.max(buy, cd));
            return buyProfit.get(idx);
        } else {
            int sell = helper(idx + 2, !buying, prices) + prices[idx];
            int cd = helper(idx + 1, buying, prices);
            sellProfit.put(idx, Math.max(sell, cd));
            return sellProfit.get(idx);
        }
    }
}
