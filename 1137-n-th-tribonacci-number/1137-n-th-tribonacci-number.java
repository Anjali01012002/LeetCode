class Solution {
    public int tribonacci(int n) {
        
        if(n==0){
            return 0;
        }else if(n==1 || n==2){
            return 1;
        }else{
            int firstTerm=0;
            int secTerm=1;
            int thirdTerm=1;
            
            for(int i=1;i<=n;i++){
                
                int fourthTerm = firstTerm + secTerm + thirdTerm;
                firstTerm = secTerm;
                secTerm = thirdTerm;
                thirdTerm = fourthTerm;
            
            }
            return firstTerm;
        }
    }
}