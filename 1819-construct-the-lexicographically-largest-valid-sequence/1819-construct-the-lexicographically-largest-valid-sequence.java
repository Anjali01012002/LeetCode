class Solution {
    public int[] constructDistancedSequence(int n) {
        int size = 2 * n - 1;
        int[] result = new int[size];
        boolean[] used = new boolean[n + 1]; 
        
        placeNumbers(result, used, 0, n);
        return result;
    }

    private boolean placeNumbers(int[] result, boolean[] used, int index, int n) {
        if (index == result.length) return true; 

        if (result[index] != 0) return placeNumbers(result, used, index + 1, n);

        for (int i = n; i >= 1; i--) { 
            if (!used[i]) {
                if (i == 1) {
                    result[index] = 1;
                    used[1] = true;
                    if (placeNumbers(result, used, index + 1, n)) return true;
                    result[index] = 0;
                    used[1] = false;
                } else if (index + i < result.length && result[index + i] == 0) {
                    result[index] = result[index + i] = i;
                    used[i] = true;
                    if (placeNumbers(result, used, index + 1, n)) return true;
                    result[index] = result[index + i] = 0;
                    used[i] = false;
                }
            }
        }
        return false;
    }
}
