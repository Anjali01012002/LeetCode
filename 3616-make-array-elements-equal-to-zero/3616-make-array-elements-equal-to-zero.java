class Solution {
    public int countValidSelections(int[] nums) {
        int count = 0;

        for(int i=0; i<nums.length;i++){
            if(nums[i]==0){
                if(dirProcess(nums.clone(), i, -1)){
                    count++;
                }
                if(dirProcess(nums.clone(), i, 1)){
                    count++;
                }
            }
        }
        return count;
    }
    private boolean dirProcess(int[] nums, int  start, int direction){
        int curr=start;

        while(curr>=0 && curr<nums.length){
            if(nums[curr]==0){
                curr+=direction;
            }else if(nums[curr]>0){
                nums[curr]--;
                direction*=-1; //reverse the direction
                curr+=direction;
            }
        }

        for(int num:nums){
            if(num!=0){
                return false;
            }
        }

         return true;
    }
}