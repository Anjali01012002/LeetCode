class Solution {
    public int punishmentNumber(int n) {
        int totalSum = 0;
        for (int i = 1; i <= n; i++) {
            int square = i * i;
            if (canBePartitioned(String.valueOf(square), 0, i)) {
                totalSum += square;
            }
        }
        return totalSum;
    }

    private boolean canBePartitioned(String str, int index, int target) {
        if (index == str.length()) return target == 0;
        
        int num = 0;
        for (int j = index; j < str.length(); j++) {
            num = num * 10 + (str.charAt(j) - '0'); 
            if (num > target) break; 
            if (canBePartitioned(str, j + 1, target - num)) return true;
        }
        return false;
    }
}
