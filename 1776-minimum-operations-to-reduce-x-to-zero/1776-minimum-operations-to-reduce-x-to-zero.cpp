class Solution {
public:
    int minOperations(vector<int>& nums, int x) {
        int n = nums.size();

        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        int k = sum - x;
        if(k == 0) return n;
        else if(k < 0) return -1;
        else{
            int res = n - helper(n, nums, k);
            if(res == n) return -1;
            return res;
        }
    }

private:
    int helper(int n, vector<int>& nums, int k){
        int res = 0;

        int st = 0;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            while(sum > k){
                sum -= nums[st++];
            }
            if(sum == k){
                res = max(res, i-st+1);
            }
        }

        return res;
    }
};