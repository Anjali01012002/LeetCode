class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count=0;
        int n=words.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(words[j].startsWith(words[i]) && words[j].endsWith(words[i])){
                    count++;
                }
            }
        }
        return count;
    }
}