class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
      if(nums.length<3){
          return new ArrayList<>();
      }  
        List<List<Integer>> result= new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            
            twoSum(nums, i+1, result, -nums[i]);
        }
        return result;
    }
    
    private void twoSum(int[] nums, int k, List<List<Integer>> result, int target){
        int i=k, j=nums.length-1;
        
        while(i<j){
            if(nums[i]+nums[j]>target){
                j--;
            }else if(nums[i]+nums[j]<target){
                i++;
            }else{
                result.add(Arrays.asList(-target, nums[i], nums[j]));
                while(i<j && nums[i]==nums[i+1]){
                    i++;
                }
                while(i<j && nums[j]==nums[j-1]){
                    j--;
                }
                i++;
                j--;
            }
        }
    }
}