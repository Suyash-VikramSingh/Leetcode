class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        if(n < k) return -1;

        int sum = 0;
        int max = 0;

        for(int i = 0; i < n; i++){
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }

        int st = max;
        int end = sum;

        while(st <= end){
            int mid = (end - st) / 2 + st;

            int splits = possibleStudents(nums, mid);

            if(splits <= k){
                end = mid - 1;
            }
            else st = mid + 1;
        }

        return st;
    }

    public int possibleStudents(int[] arr, int k){
        int splits = 1;
        int sum = 0;

        int n = arr.length;

        for(int i = 0; i < n; i++){
            if(sum + arr[i] <= k){
                sum += arr[i];
            }
            else{
                splits++;
                sum = arr[i];
            }
        }

        return splits;
    }
}