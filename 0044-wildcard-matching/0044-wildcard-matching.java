class Solution {
    public boolean isMatch(String s, String p) {
        p = filter(p);

        char[] a = s.toCharArray();
        char[] b = p.toCharArray();

        int n = a.length;
        int m = b.length;

        boolean[] dp = new boolean[m+1];
        dp[m] = true;

        int j = m-1;
        while(j >= 0 && b[j] == '*') dp[j--] = true;
        for(; j >= 0; j--) dp[j] = false;

        for(int i = n-1; i >= 0; i--){
            boolean[] temp = new boolean[m+1];
            temp[m] = false;
            for(j = m-1; j >= 0; j--){
                boolean res = false;
                if(a[i] == b[j] || b[j] == '?') res = dp[j+1];
                else if(b[j] == '*') res = temp[j+1] ||
                                           dp[j];
                temp[j] = res;
            }
            dp = temp;
        }

        return dp[0];
    }

    private String filter(String s){
        int n = s.length();
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '*' && i > 0 && s.charAt(i-1) == '*')
                continue;
            str.append(s.charAt(i));
        }

        return str.toString();
    }
}