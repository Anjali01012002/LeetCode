class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }

        String doubles = s + s;

        return doubles.contains(goal);
    }
}