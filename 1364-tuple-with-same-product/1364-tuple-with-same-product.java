class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> productCount = new HashMap<>();
        int n = nums.length;
        int result = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int product = nums[i] * nums[j];
                productCount.put(product, productCount.getOrDefault(product, 0) + 1);
            }
        }

        for (int freq : productCount.values()) {
            if (freq > 1) {
                result += (freq * (freq - 1) / 2) * 8;
            }
        }

        return result;
    }
}
