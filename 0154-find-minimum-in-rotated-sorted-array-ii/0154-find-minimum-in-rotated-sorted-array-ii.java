class Solution {
    public int findMin(int[] nums) {
        int st = 0, end = nums.length - 1;

        int res = 5000;
        while(st <= end){
            int mid = (end - st) / 2 + st;

            if(nums[st] == nums[mid] && nums[mid] == nums[end]){
                res = Math.min(res, nums[mid]);
                st++;
                end--;
            }
            else if(nums[st] <= nums[mid]){
                res = Math.min(res, nums[st]);
                st = mid + 1;
            }
            else{
                res = Math.min(res, nums[mid]);
                end = mid - 1;
            }
        }

        return res;
    }
}