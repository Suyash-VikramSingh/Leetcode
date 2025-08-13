class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();

        int[] sum = new int[n+1];

        for(int i = 1; i <= n; i++){
            sum[i] = sum[i-1] + nums[i-1];
        }

        int rem, count = 0;
        for(int i = 0; i <= n; i++){
            rem = sum[i] % k;
            if(rem < 0) rem += k;
            if(mp.containsKey(rem)) {
                count += mp.get(rem);
                mp.put(rem, mp.get(rem) + 1);
            }
            else mp.put(rem, 1);
        }

        return count;
    }
}