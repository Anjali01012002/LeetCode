class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;

        int incLen = 1, decLen = 1, maxLen = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                incLen++;  // Increase the length of increasing subarray
                decLen = 1;  // Reset decreasing length
            } else if (nums[i] < nums[i - 1]) {
                decLen++;  // Increase the length of decreasing subarray
                incLen = 1;  // Reset increasing length
            } else {
                incLen = decLen = 1; // Reset on equal elements
            }
            maxLen = Math.max(maxLen, Math.max(incLen, decLen));
        }

        return maxLen;
    }
}
