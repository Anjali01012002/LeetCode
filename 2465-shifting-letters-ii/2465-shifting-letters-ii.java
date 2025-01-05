class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diff = new int[n + 1];

        // Build the difference array
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];
            
            // Forward shift adds +1, backward shift adds -1
            diff[start] += (direction == 1) ? 1 : -1;
            diff[end + 1] += (direction == 1) ? -1 : 1;
        }

        // Compute the prefix sum for net shifts
        int[] netShifts = new int[n];
        int cumulativeShift = 0;
        for (int i = 0; i < n; i++) {
            cumulativeShift += diff[i];
            netShifts[i] = cumulativeShift;
        }

        // Apply the shifts to the string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char originalChar = s.charAt(i);
            int shift = netShifts[i];

            // Calculate the new character
            int newChar = ((originalChar - 'a') + shift) % 26;
            if (newChar < 0) {
                newChar += 26; // Handle negative wraparound
            }
            result.append((char) ('a' + newChar));
        }

        return result.toString();
    }
}
