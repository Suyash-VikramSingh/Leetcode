class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int st = 1;
        int end = piles[0];

        for(int pile : piles) end = Math.max(end, pile);

        while(st <= end){
            int mid = (end-st)/2 + st;

            if(isPossible(mid, piles, h))
                end = mid - 1;
            else 
                st = mid + 1;
        }

        return st;
    }

    private boolean isPossible(int r, int[] arr, int t){
        int n = arr.length;

        long res = 0;
        for(int i = 0; i < n; i++){
            res += (arr[i] + r - 1) / r;
        }

        return res <= t;
    }
}