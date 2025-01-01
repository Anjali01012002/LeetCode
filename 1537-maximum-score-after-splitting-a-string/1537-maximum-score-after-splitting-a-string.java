class Solution {
    public int maxScore(String s) {
        int n=s.length();
        int maxScore=0; 

        for(int i=1; i<n; i++){
            int leftZero=countZero(s.substring(0,i));
            int rightOnes=countOnes(s.substring(i));
            int currentScore=leftZero+rightOnes;
            maxScore=Math.max(maxScore, currentScore);
        }
        return maxScore;
    }
    private int countZero(String str){
        int count=0;
        for(char c:str.toCharArray()){
            if(c=='0'){
                count++;
            }
        }
        return count;
    }

    private int countOnes(String str){
        int count=0;
        for(char c:str.toCharArray()){
            if(c=='1'){
                count++;
            }
        }
        return count;
    }
}