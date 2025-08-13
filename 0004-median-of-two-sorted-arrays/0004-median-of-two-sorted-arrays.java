class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int len = n + m;

        if(n > m) return findMedianSortedArrays(nums2, nums1);

        int req = (n+m+1)/2;
        int low = 0;
        int high = n;
        while(low <= high){
            int mid1 = ((high-low)/2 + low);
            int mid2 = req-mid1;

            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            if(0 <= mid1-1) l1 = nums1[mid1-1];
            if(0 <= mid2-1) l2 = nums2[mid2-1];
            if(mid1 < n) r1 = nums1[mid1];
            if(mid2 < m) r2 = nums2[mid2];

            if(l1 <= r2 && l2 <= r1){
                if(len % 2 == 0) return ((double)Math.max(l1, l2)+Math.min(r1, r2))/2;
                else return Math.max(l1, l2);
            }
            else if(l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
        }

        return 0;
    }
}