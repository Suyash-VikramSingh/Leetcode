class Solution {
    public List<List<String>> partition(String s){
        int n = s.length();

        boolean[][] isPal = new boolean[n][n];
        for(int i = n-1; i >= 0; i--){
            for(int j = i; j < n; j++){
                if(s.charAt(i) == s.charAt(j) && ((j-i+1) <= 2 || isPal[i+1][j-1])){
                    isPal[i][j] = true;
                }
            }
        }

        List<List<String>> res = new ArrayList<>();
        partition(0, n, s, isPal, new ArrayList<>(), res);

        return res;
    }

    private void partition(int i, int n, String s, boolean[][] isPal, List<String> curr, List<List<String>> res){
        if(i == n){
            res.add(curr);
            return;
        }

        for(int j = i; j < n; j++){
            if(isPal[i][j]){
                List<String> l = new ArrayList<>(curr);
                l.add(s.substring(i, j+1));

                partition(j+1, n, s, isPal, l, res);
            }
        }
    }
}