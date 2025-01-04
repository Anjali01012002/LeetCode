class Solution {
    public int countPalindromicSubsequence(String s) {
        int result = 0;
        for(char ch='a'; ch<='z'; ch++){
            int first=-1, last=-1;

            for(int i=0;i<s.length();i++){
                if(s.charAt(i)==ch){
                    if(first==-1){
                        first=i;
                    }
                    last=i;
                }
            }
            if(first!=-1 && last!=-1 && last>first){
               HashSet<Character> middleChar=new HashSet<>();
                for(int i=first+1;i<last;i++){
                    middleChar.add(s.charAt(i));
                }
                result+=middleChar.size();
            }
        }
        return result;
    }
}