class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[] dp = new int[amount+1];

        for(int t = 0; t <= amount; t++){
            if(t % coins[n-1] == 0) dp[t] = t/coins[n-1];
            else dp[t] = 1000000000;
        }

        for(int i = n-2; i >= 0; i--){
            for(int t = coins[i]; t <= amount; t++){
                int pick = Integer.MAX_VALUE;
                if(coins[i] <= t) pick = 1+dp[t-coins[i]];

                int notPick = dp[t];

                dp[t] = Math.min(pick, notPick);
            }
        }

        return dp[amount] >= 1000000000 ? -1 : dp[amount];
    }
}