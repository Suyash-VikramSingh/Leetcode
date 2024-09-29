class Solution {
    public int countOfSubstrings(String word, int k) {
        int n = word.length();
        int ans = 0;
        for(int j = 0; j <= n-5-k; j++){
            for(int i = 0; i <= n-5-k-j; i++){
                ans += check(word.substring(i,i+5+k+j) , k);
            }
        }

        return ans;
    }

    public int check(String s, int k){
        int n = s.length();
        int count = 0;
        int[] arr = new int[5];

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);

            if(ch == 'a' && arr[0] != 1){
                arr[0] = 1;
                count++;
            }else if(ch == 'e' && arr[1] != 1){
                arr[1] = 1;
                count++;
            }else if(ch == 'i' && arr[2] != 1){
                arr[2] = 1;
                count++;
            }else if(ch == 'o' && arr[3] != 1){
                arr[3] = 1;
                count++;
            }else if(ch == 'u' && arr[4] != 1){
                arr[4] = 1;
                count++;
            }else if(ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u'){
                k--;
            }
        }
        if(k == 0 && count == 5) return 1;
        else return 0;
    }
}