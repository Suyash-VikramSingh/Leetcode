class Solution {
    class disJointSet{
        int[] par;
        int[] size;
        int v;

        disJointSet(int n){
            v = n;

            par = new int[n+1];
            size = new int[n+1];
            for(int i = 0; i <= n; i++) {
                par[i] = i;
                size[i] = 1;
            }
        }

        int find(int x){
            if(x == par[x]) return x;

            return par[x] = find(par[x]);
        }

        void union(int u, int v){
            int U = find(u);
            int V = find(v);

            if(U == V) return;

            if(size[U] < size[V]){
                par[U] = V;
                size[V] += size[U];
            }
            else{
                par[V] = U;
                size[U] += size[V];
            }
        }
    }
    public int removeStones(int[][] stones) {
        int len = stones.length;
        int m = 0; // max row
        int n = 0; // max col
        for(int[] s : stones){
            m = Math.max(m, s[0]);
            n = Math.max(n, s[1]);
        }
        
        disJointSet ds = new disJointSet(m+n+1);

        HashSet<Integer> hs = new HashSet<>();
        for(int[] s : stones){
            int u = s[0];
            int v = s[1]+m+1;
            ds.union(u, v);
            hs.add(u);
            hs.add(v);
        }

        int count = 0;
        for(int val : hs){
            if(val == ds.par[val]) count++;
        }

        return len - count;
    }
}