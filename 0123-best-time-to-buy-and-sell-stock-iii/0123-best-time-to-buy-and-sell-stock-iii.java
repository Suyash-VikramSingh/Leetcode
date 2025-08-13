class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[] dp = new int[5];

        for(int i = n-1; i >= 0; i--){
            int[] temp = new int[5];
            for(int j = 0; j < 4; j++){
                int profit = 0;
                if(j % 2 == 0)
                    profit = Math.max(dp[j+1] - prices[i], dp[j]);
                else
                    profit = Math.max(dp[j+1] + prices[i], dp[j]);

                temp[j] = profit;
            }
            dp = temp;
        }
        
        return dp[0];
    }
}