class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int start=0,end=nums.length-1;
        int temp;
        while(start<=end) {
            // for start index
                temp = target - nums[start];
                if (map.containsKey(temp)) {
                    return new int[] { map.get(temp), start };
                }
                map.put(nums[start], start);

            // for end index
                temp = target - nums[end];
                if (map.containsKey(temp)) {
                    return new int[] { map.get(temp), end };
                }
                map.put(nums[end], end);

            start++;
            end--;
        }
        return null;
    }
}