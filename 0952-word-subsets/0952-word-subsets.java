import java.util.*;

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();
        
        int[] requiredFreq = new int[26];  
        
        for (String word : words2) {
            int[] wordFreq = new int[26];  
            for (char c : word.toCharArray()) {
                wordFreq[c - 'a']++;  
            }
            for (int i = 0; i < 26; i++) {
                requiredFreq[i] = Math.max(requiredFreq[i], wordFreq[i]);
            }
        }

        for (String word : words1) {
            int[] wordFreq = new int[26]; 
            for (char c : word.toCharArray()) {
                wordFreq[c - 'a']++;  
            }
            boolean isUniversal = true;
            for (int i = 0; i < 26; i++) {
                if (wordFreq[i] < requiredFreq[i]) {
                    isUniversal = false;
                    break;
                }
            }

            if (isUniversal) {
                result.add(word);
            }
        }

        return result;
    }
}
