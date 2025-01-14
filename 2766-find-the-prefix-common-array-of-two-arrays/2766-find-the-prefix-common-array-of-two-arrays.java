class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] freq = new int[n + 1]; // Frequency array for numbers 1 to n
        int[] C = new int[n]; // Result array
        int commonCount = 0; // To track common numbers
        
        for (int i = 0; i < n; i++) {
            // Increment frequency for the current numbers in A and B
            freq[A[i]]++; // Increment for A[i]
            if (freq[A[i]] == 2) { // If it appears in both A and B
                commonCount++;
            }
            
            freq[B[i]]++; // Increment for B[i]
            if (freq[B[i]] == 2) { // If it appears in both A and B
                commonCount++;
            }
            
            // Update the prefix common array
            C[i] = commonCount;
        }
        
        return C;

    }
}