class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int dir = 0;
        /*
        dir = 0: left to right
        dir = 1: top to down
        dir = 2: right to left
        dir = 3: down to top
         */

         List<Integer> result = new ArrayList<>();

         int top=0, bottom = m-1;
         int left=0, right = n-1;

         while(top <= bottom && left <= right){
            if(dir == 0){
                for(int col = left; col <= right; col++){
                    result.add(matrix[top][col]);
                }
                top++;
            }else if(dir == 1){
                for(int row = top; row <= bottom; row++){
                    result.add(matrix[row][right]);
                }
                right--;
            }else if(dir == 2){
                for(int col = right; col >= left; col--){
                    result.add(matrix[bottom][col]);
                }
                bottom--;
            }else if(dir == 3){
                for(int row = bottom; row >= top; row--){
                    result.add(matrix[row][left]);
                }
                left++;
            }
            // Update direction
            dir++;
            if(dir==4){
                dir=0;
            }
         }
         return result;


    }
}