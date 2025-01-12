class Solution {
    public boolean canBeValid(String s, String locked) {
        int n=s.length();
        if(n%2!=0){
            return false;
        }
        int balance=0;
        int canChange=0;

        //left to right
        for(int i=0;i<n;i++){
            if(locked.charAt(i)=='0'){
                canChange++;
            }else if(s.charAt(i)=='('){
                balance++;
            }else{
                balance--;
            }
            if(balance+canChange<0){
                return false;
            }
        }

        balance=0;
        canChange=0;
        //right to left
        for(int i=n-1;i>=0;i--){
            if(locked.charAt(i)=='0'){
                canChange++;
            }else if(s.charAt(i)==')'){
                balance++;
            }else{
                balance--;
            }

            if(balance+canChange<0){
                return false;
            }
        }
        return true;

    }
}