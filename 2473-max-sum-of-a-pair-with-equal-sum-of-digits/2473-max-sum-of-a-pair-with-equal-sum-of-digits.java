class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxSum = -1;
        
        for (int num : nums) {
            int digitSum = getDigitSum(num);
            
            if (map.containsKey(digitSum)) {
                maxSum = Math.max(maxSum, num + map.get(digitSum));
                map.put(digitSum, Math.max(num, map.get(digitSum)));
            } else {
                map.put(digitSum, num);
            }
        }
        
        return maxSum;
    }
    
    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
