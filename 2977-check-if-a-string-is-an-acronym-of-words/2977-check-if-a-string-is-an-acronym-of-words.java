class Solution {
    public boolean isAcronym(List<String> words, String s) {
        if(words.size() != s.length()){
            return false;
        }

        StringBuilder acronym = new StringBuilder();

        for(String word : words){
            acronym.append(word.charAt(0));
        }

        return acronym.toString().equals(s);
    }
}