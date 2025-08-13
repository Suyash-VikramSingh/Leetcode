class Solution {
    public int minDistance(String word1, String word2) {
        char[] a = word1.toCharArray();
        char[] b = word2.toCharArray();

        int n = a.length;
        int m = b.length;

        int[] dp = new int[m+1];

        for(int j = 0; j < m; j++)
            dp[j] = m-j;

        for(int i = n-1; i >= 0; i--){
            int[] temp = new int[m+1];
            temp[m] = n-i;
            for(int j = m-1; j >= 0; j--){
                if(a[i] == b[j]) temp[j] = dp[j+1];
                else temp[j] = 1 + Math.min(temp[j+1], Math.min(dp[j], dp[j+1]));
            }
            dp = temp;
        }

        return dp[0];
    }
}