class Solution {
public:
    string largestGoodInteger(string num) {
        int n = num.length();

        string ans = "";
        int len = 1;
        for(int i = 1; i < n; i++){
            if(num[i] == num[i-1]){
                len++;
                if(len == 3){
                    if(ans == "" || num[i] > ans[0]) ans = num.substr(i-2, 3);
                    len = 0;
                }
            }
            else{
                len = 1;
            }
        }

        return ans;
    }
};