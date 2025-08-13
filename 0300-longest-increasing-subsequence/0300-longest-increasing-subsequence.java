class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        List<Integer> l = new ArrayList<>();
        l.add(nums[0]);

        for(int i = 1; i < n; i++){
            int idx = lowerBound(l, nums[i]);
            if(idx >= l.size()) l.add(nums[i]);
            else l.set(idx, nums[i]);
        }

        return l.size();
    }

    private int lowerBound(List<Integer> nums, int k){
        int n = nums.size();
        
        int low = 0;
        int high = n-1;

        while(low <= high){
            int mid = (high - low) / 2 + low;

            if(nums.get(mid) < k) low = mid + 1;
            else high = mid - 1;
        }

        return low;
    }
}