class Solution {
    //if you are woundring how it is handeling the numbers which are in the range of low - high but are not in the matrix see Notes;
    public int kthSmallest(int[][] mat, int k) {
        int n = mat.length;
        int low = mat[0][0];
        int high = mat[n-1][n-1];

        while(low <= high){
            int mid = (high-low)/2 + low;

            int count = getCount(mat, mid, n);
            
            if(count < k) low = mid + 1;
            else high = mid-1;
        }

        return low;
    }
    int getCount(int[][] mat, int t, int n){
        int count = 0;
        
        for(int[] a : mat){
            int st = 0;
            int end = n-1;
            
            while(st <= end){
                int mid = (end-st)/2 + st;
                
                if(t < a[mid]) end = mid - 1;
                else st = mid + 1;
            }
            
            count += st;
        }
        
        return count;
    }
}