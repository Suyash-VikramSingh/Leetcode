import java.util.PriorityQueue;

class Solution {
    private boolean isValid(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.offer(new int[]{0, 0, 0});
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int cost = curr[0];
            int x = curr[1];
            int y = curr[2];

            if (visited[x][y]) continue;
            if (x == m - 1 && y == n - 1) return cost;
            visited[x][y] = true;

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (isValid(nx, ny, m, n) && !visited[nx][ny]) {
                    int newCost = cost + (grid[x][y] == dir + 1 ? 0 : 1);
                    minHeap.offer(new int[]{newCost, nx, ny});
                }
            }
        }

        return -1;
    }
}
