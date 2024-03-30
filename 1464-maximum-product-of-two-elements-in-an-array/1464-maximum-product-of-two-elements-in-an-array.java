class Solution {
    public int maxProduct(int[] nums) {
        int secMax = -1;
        int max = -1;
        
        for(int i = 0; i<nums.length;i++){
            
            if(max<nums[i]){
                secMax = max;
                max =nums[i];
            }else if(secMax<nums[i]){
                secMax = nums[i];
            }
        }
        int ans = (max-1)*(secMax-1);
        return ans;
    }
}