class Solution {
    public int countServers(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        int[] indexColCount=new int[n];
        int[] indexRowCount=new int[m];

        for(int row=0; row<m; row++){
            for(int col=0; col<n; col++){
                if(grid[row][col]==1){
                    indexColCount[col] += 1;
                    indexRowCount[row] += 1;
                }
            }
        }

        int resultServers=0;
        for(int row=0; row<m; row++){
            for(int col=0; col<n; col++){
                if(grid[row][col]==1 && (indexColCount[col]>1||indexRowCount[row]>1)){
                    resultServers++;
                }
            }
        }
        return resultServers;
    }
}