class Solution {
public:
    int possibleStringCount(string word, int k) {
        const int MOD = 1e9 + 7;
        int n = word.length();

        int cnt = 1;
        vector<int> group;
        for(int i = 1; i < n; i++){
            if(word[i-1] != word[i]){
                group.push_back(cnt);
                cnt = 0;
            }

            cnt++;
        }
        group.push_back(cnt);

        int m = group.size();

        int total = 1;
        for(int f : group){
            total = (1LL * total * f) % MOD;
        }

        if(m >= k) return total;

        vector<int> count(k), newCount(k), preSum(k);
        count[0] = 1;

        for(int g : group){
            preSum[0] = count[0];

            for(int i = 1; i < k; i++){
                preSum[i] = (preSum[i-1] + count[i]) % MOD;
            }

            for(int i = 1; i < k; i++){
                int r = preSum[i-1];
                int l = 0;
                if(0 <= i-1-g){
                    l = preSum[i-1-g];
                }

                newCount[i] = (r - l + MOD) % MOD;
            }

            swap(count, newCount);
            fill(newCount.begin(), newCount.end(), 0);
        }



        int invalid_cnt = 0;
        for(int i = 0; i < k; i++){
            invalid_cnt = (invalid_cnt + count[i]) % MOD;
        }

        return (total - invalid_cnt + MOD) % MOD;
    }
};