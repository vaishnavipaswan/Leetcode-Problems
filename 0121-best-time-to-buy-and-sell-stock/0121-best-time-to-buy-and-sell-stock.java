class Solution {
    public int maxProfit(int[] prices) {
        int max_profit=0;
        int min=Integer.MAX_VALUE;
        int n=prices.length;
        for(int i=0;i<n;i++){
                min=Math.min(min,prices[i]);
                max_profit=Math.max(max_profit,prices[i]-min);
        }
        return max_profit;
    }
}