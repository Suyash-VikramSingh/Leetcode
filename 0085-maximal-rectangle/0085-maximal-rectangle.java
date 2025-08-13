class Solution {
    public int maximalRectangle(char[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[] arr = new int[n];
        for(int j = 0; j < n; j++){
            arr[j] = mat[0][j] - '0';
        }

        int res = largestRectangleArea(arr);

        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == '1'){
                    arr[j]++;
                }
                else{
                    arr[j] = 0;
                }
            }
            res = Math.max(res, largestRectangleArea(arr));
        }

        return res;
    }

    private int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if(n == 1) return heights[0];
        Stack<Integer> st = new Stack<>();
        int[] nse = new int[n];
        int[] pse = new int[n];
        // to calculate next smaller element
        nse[n-1] = n;
        st.push(n-1);
        for(int i = n-2; i >= 0; i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) st.pop();
            if(st.isEmpty()) nse[i] = n;
            else nse[i] = st.peek();
            st.push(i);
        }

        // empty the stack
        while(!st.isEmpty()) st.pop();

        // to calculate previous smaller element
        pse[0] = -1;
        st.push(0);
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) st.pop();
            if(st.isEmpty()) pse[i] = -1;
            else pse[i] = st.peek();
            st.push(i);
        }

        //calculate maximum area of rectangle
        int max = -1;
        int area;
        for(int i = 0; i < n; i++){
            area = heights[i] * (nse[i] - pse[i] - 1);
            if(area > max) max = area;
        }
        return max;
    }
}