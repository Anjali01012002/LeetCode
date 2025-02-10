class Solution {
    public String clearDigits(String s) {
        StringBuilder stack=new StringBuilder();
        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)){
                if(stack.length()>0){
                    stack.deleteCharAt(stack.length()-1);
                }
            }else{
                stack.append(ch);
            }
        }
        return stack.toString();
    }
}