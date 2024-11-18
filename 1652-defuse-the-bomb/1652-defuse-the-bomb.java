class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;

        if(k == 0){
            return new int[n];
        }

        int idx;
        if(k > 0){
            int[] preSum = new int[n];

            preSum[0] = code[0];

            for(int i = 1; i < n; i++){
                preSum[i] = preSum[i-1] + code[i];
            }

            for(int i = 0; i < n; i++){
                idx = (i+k);
                if(idx >= n){
                    code[i] = preSum[n-1] - preSum[i];
                    idx = idx%n;
                    code[i] += preSum[idx];
                }
                else
                    code[i] = preSum[idx] - preSum[i];
            }
        }
        else{
            int[] sfxSum = new int[n];

            sfxSum[n-1] = code[n-1];

            for(int i = n-2; i >= 0; i--){
                sfxSum[i] = sfxSum[i+1] + code[i];
            }

            for(int i = 0; i < n; i++){
                idx = (i+k);
                if(idx < 0){
                    code[i] = sfxSum[0] - sfxSum[i];
                    idx = idx + n;
                    code[i] += sfxSum[idx];
                }
                else
                    code[i] = sfxSum[idx] - sfxSum[i];
            }
        }

        return code;
    }
}