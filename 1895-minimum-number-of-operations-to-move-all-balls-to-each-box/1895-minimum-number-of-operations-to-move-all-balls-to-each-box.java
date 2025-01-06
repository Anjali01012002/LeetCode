class Solution {
    public int[] minOperations(String boxes) {
        int n=boxes.length();
        int[] result = new int[n];

        int leftMoves=0, leftBalls=0;
        for(int i=1;i<n;i++){
            if(boxes.charAt(i-1)=='1'){
                leftBalls++;
            }
            leftMoves+=leftBalls;
            result[i]+=leftMoves;
        }
        int rightMoves=0, rightBalls=0;
        for(int i=n-2;i>=0;i--){
            if(boxes.charAt(i+1)=='1'){
                rightBalls++;
            }
            rightMoves+=rightBalls;
            result[i]+=rightMoves;
        }
        return result;
    }
}