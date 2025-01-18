class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // Right, Left, Down, Up
        Deque<int[]> deque = new LinkedList<>();
        int[][] dist = new int[m][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        
        deque.offerFirst(new int[]{0, 0, 0}); // {row, col, cost}
        dist[0][0] = 0;

        while (!deque.isEmpty()) {
            int[] curr = deque.pollFirst();
            int x = curr[0], y = curr[1], cost = curr[2];
            
            if (x == m - 1 && y == n - 1) return cost;

            for (int d = 0; d < 4; d++) {
                int nx = x + directions[d][0];
                int ny = y + directions[d][1];
                int newCost = (d + 1 == grid[x][y]) ? cost : cost + 1; // No cost if matching direction

                if (nx >= 0 && ny >= 0 && nx < m && ny < n && newCost < dist[nx][ny]) {
                    dist[nx][ny] = newCost;
                    if (d + 1 == grid[x][y]) {
                        deque.offerFirst(new int[]{nx, ny, newCost}); // 0-cost move
                    } else {
                        deque.offerLast(new int[]{nx, ny, newCost}); // 1-cost move
                    }
                }
            }
        }
        return -1; // Should never reach here
    }
}