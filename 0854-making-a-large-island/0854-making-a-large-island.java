class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        Map<Integer, Integer> islandArea = new HashMap<>();
        int index = 2; 
        int maxArea = 0;
    
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j, index);
                    islandArea.put(index, area);
                    maxArea = Math.max(maxArea, area);
                    index++;
                }
            }
        }
        
        boolean hasZero = false;
        int[] directions = {0, 1, 0, -1, 0};
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    hasZero = true;
                    Set<Integer> uniqueIslands = new HashSet<>();
                    
                    // Check all 4 directions
                    for (int d = 0; d < 4; d++) {
                        int ni = i + directions[d];
                        int nj = j + directions[d + 1];
                        if (ni >= 0 && ni < n && nj >= 0 && nj < n && grid[ni][nj] > 1) {
                            uniqueIslands.add(grid[ni][nj]);
                        }
                    }
                    
                    int newArea = 1; 
                    for (int island : uniqueIslands) {
                        newArea += islandArea.get(island);
                    }
                    
                    maxArea = Math.max(maxArea, newArea);
                }
            }
        }
        
        return hasZero ? maxArea : n * n; 
    }

    private int dfs(int[][] grid, int i, int j, int index) {
        int n = grid.length;
        if (i < 0 || j < 0 || i >= n || j >= n || grid[i][j] != 1) return 0;
        
        grid[i][j] = index; 
        int area = 1;
        int[] directions = {0, 1, 0, -1, 0};
        
        for (int d = 0; d < 4; d++) {
            int ni = i + directions[d];
            int nj = j + directions[d + 1];
            area += dfs(grid, ni, nj, index);
        }
        
        return area;
    }
}
