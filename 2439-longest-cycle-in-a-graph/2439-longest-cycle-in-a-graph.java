class Solution {
    private int size = 0;
    public int longestCycle(int[] edges) {
        int n = edges.length;

        boolean[] visited = new boolean[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i, edges, visited, st);
            }
        }

        visited = new boolean[n];
        List<Integer>[] adj = reverse(n, edges);
        int res = -1;

        while(!st.isEmpty()){
            int node = st.pop();
            if(!visited[node]){
                size = 0;
                dfs(node, adj, visited);
                if(size != 1) res = Math.max(res, size);
            }
        }

        return res;
    }

    void dfs(int curr, int[] edges, boolean[] visited, Stack<Integer> st){
        visited[curr] = true;

        int node = edges[curr];
        if(node != -1 && !visited[node]){
            dfs(node, edges, visited, st);
        }

        st.push(curr);
    }

    void dfs(int curr, List<Integer>[] adj, boolean[] visited){
        visited[curr] = true;
        size++;
        for(int node : adj[curr]){
            if(!visited[node]){
                dfs(node, adj, visited);
            }
        }
    }

    List<Integer>[] reverse(int n, int[] e){
        List<Integer>[] ans = new ArrayList[n];
        for(int i = 0; i < n; i++){
            ans[i] = new ArrayList<>();
        }

        for(int u = 0; u < n; u++){
            int v = e[u];

            if(v != -1) ans[v].add(u);
        }

        return ans;
    }
}