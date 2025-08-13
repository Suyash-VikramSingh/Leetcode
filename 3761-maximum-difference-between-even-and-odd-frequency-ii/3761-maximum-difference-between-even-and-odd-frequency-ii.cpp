class Solution {
public:
    int maxDifference(string s, int k) {
        int n = s.length();

        vector<vector<int>> pre(5, vector<int>(n+1, 0));

        for(int i = 1; i < n+1; i++){
            pre[s[i-1] - 48][i]++;

            for(int d = 0; d < 5; d++){
                pre[d][i] += pre[d][i-1];
            }
        }

        int res = -1e9;

        for(int a = 0; a < 5; a++){
            for(int b = 0; b < 5; b++){
                vector<int> minVal(4, 1e9);
                vector<int> minIdx(4, -1);
                minVal[0] = minIdx[0] = 0;

                for(int r = k; r <= n; r++){
                    int p = (getP(pre[a][r], pre[b][r]) + 2) % 4;

                    if(minVal[p] != 1e9){
                        int l = minIdx[p];

                        if(pre[b][l] == pre[b][r]) continue;

                        int fa = pre[a][r] - pre[a][l];
                        int fb = pre[b][r] - pre[b][l];

                        if(fa%2 != 0 && fb%2 == 0){
                            res = max(res, fa - fb);
                        }
                    }

                    int i = r-k+1;
                    int q = getP(pre[a][i], pre[b][i]);
                    int diff = pre[a][i] - pre[b][i];

                    if(minVal[q] > diff){
                        minVal[q] = diff;
                        minIdx[q] = i;
                    }
                }
            }
        }

        return res;
    }
private:
    int getP(int a, int b) {
        if (a % 2 == 0) {
            return (b % 2 == 0) ? 0 : 1;
        } else {
            return (b % 2 == 0) ? 2 : 3;
        }
    }
};