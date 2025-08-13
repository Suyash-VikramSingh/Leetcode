class Solution {
    private int timer = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[][] adj = getadj(n, connections);

        List<List<Integer>> res = new ArrayList<>();
        dfs(0, -1, adj, new boolean[n], new int[n], new int[n], res);

        return res;
    }

    public void dfs(int curr,int parent, int[][] adj, boolean[] visited, int[] time, int[] low, List<List<Integer>> res){
        time[curr] = low[curr] = timer++;
        visited[curr] = true;

        for(int node : adj[curr]){
            if(node == parent) continue;

            if(!visited[node]){
                //calling dfs if conditions are meet
                dfs(node, curr, adj, visited, time, low, res);

                // checking for critical connection
                if(time[curr] < low[node]){
                    res.add(Arrays.asList(new Integer[]{curr, node}));
                }
            }

            // updating curr's low
            low[curr] = Math.min(low[curr], low[node]);
        }
    }

    public int[][] getadj(int n, List<List<Integer>> connections){
        List<Integer>[] lists = new ArrayList[n];
        for(int i = 0; i < n; i++){
            lists[i] = new ArrayList<>(); 
        }

        for(List<Integer> c : connections){
            int u = c.get(0);
            int v = c.get(1);
            lists[u].add(v);
            lists[v].add(u);
        }

        int[][] adj = new int[n][];
        for (int i = 0; i < n; i++) {
            int size = lists[i].size();
            adj[i] = new int[size];

            for (int j = 0; j < size; j++) {
                adj[i][j] = lists[i].get(j);
            }
        }

        return adj;
    }
}