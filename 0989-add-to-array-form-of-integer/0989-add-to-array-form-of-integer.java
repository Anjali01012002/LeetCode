class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans=new ArrayList<>();
        
        int p = num.length - 1;
        
        int carry = 0;
        
        while(p>=0 || k>0){
            int numVal = 0;
            if(p>=0){
                numVal = num[p];
            }
            int dig=k%10;
            int sum = numVal + dig + carry;
            int digit = sum%10;
            carry = sum/10;
            
            ans.add(digit);
            
            p--; //moving the pointer
            k = k/10; //remaining the last digit from k
        }
        if(carry>0){
            ans.add(carry);
        }
        Collections.reverse(ans); //reversing the answer arraylist
        return ans;
    }
}