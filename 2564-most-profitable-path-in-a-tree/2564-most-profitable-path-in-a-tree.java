class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int v = amount.length;
        List<List<Integer>> adj = fill(v, edges);

        int[] arr = new int[v];
        Arrays.fill(arr, -1);
        boolean[] visited = new boolean[v];

        dfsBob(bob, 0, visited, adj, arr);

        visited = new boolean[v];

        return dfsA(0, 0, visited, adj, amount, arr);
    }

    private int dfsA(int i, int level, boolean[] visited, List<List<Integer>> adj, int[] amount, int[] levels){
        visited[i] = true;

        int cost = 0;

        int blevel = levels[i];
        if(level == blevel) cost += amount[i] / 2;
        else if(level < blevel || blevel == -1) cost += amount[i];

        List<Integer> l = adj.get(i);
        int n = l.size();

        if(n == 0) return cost;
        
        int res = Integer.MIN_VALUE;
        for(int node : l){
            if(!visited[node])
                res = Math.max(res, dfsA(node, level+1, visited, adj, amount, levels));
        }

        if (res == Integer.MIN_VALUE) return cost;
        return cost + res;
    }

    private boolean dfsBob(int bob, int t, boolean[] visited, List<List<Integer>> adj, int[] arr){
        arr[bob] = t;
        visited[bob] = true;

        if(bob == 0) return true;

        for(int node : adj.get(bob)){
            if(!visited[node])
                if(dfsBob(node, t + 1, visited, adj, arr)) return true;
        }

        arr[bob] = -1;
        return false;
    }

    private List<List<Integer>> fill(int v, int[][] edges){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < v; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] arr : edges){
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(arr[0]);
        }

        return adj;
    }
}