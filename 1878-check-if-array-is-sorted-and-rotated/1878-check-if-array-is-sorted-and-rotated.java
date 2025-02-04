class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int breakCount = 0;
        for(int i = 0; i < n-1; i++){
            if(nums[i] > nums[i+1]){
                breakCount++;
            }
        }

        if(nums[n-1] > nums[0]){
            breakCount++;
        }

        return breakCount <= 1;
    }
}