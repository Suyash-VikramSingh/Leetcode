class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length,pivot = 0;
        int st = 0, end = n-1, mid;

        if(n == 1) return nums[0] == target;

        if(nums[st] == nums[end]){
            do end--;
            while (nums[end] == nums[end + 1] && st < end);
            if(st != end) {
                do st++;
                while(nums[st] == nums[st-1]);
            }
        }

        while(st < end){
            mid = ((end-st)/2)+st;
            if(nums[mid] <= nums[n-1]) end = mid-1;
            else st = mid+1;
        }

        if (st != 0 && nums[st] < nums[st - 1]) pivot = st;
        else if (nums[st] > nums[st + 1]) pivot = st + 1;

        if(pivot == 0){
            st = 0;
            end = n-1;
        }else if(target >= nums[0]){
            st = 0;
            end = pivot-1;
        }else{
            st = pivot;
            end = n-1;
        }

        while(st <= end){
            mid = ((end-st)/2)+st;

            if(nums[mid] == target) return true;
            else if(nums[mid] < target) st = mid+1;
            else end = mid-1;
        }

        return false;
    }
}