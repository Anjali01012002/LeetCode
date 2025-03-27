class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n=nums.size();

        int majority = -1, count = 0;
        for(int num:nums){
            if(count==0){
                majority=num;
                count=1;
            }else if(num==majority){
                count++;
            }else{
                count--;
            }
        }

        int totalCount=0;
        for(int num:nums){
            if(num==majority){
                totalCount++;
            }
        }

        int leftCount=0;
        for(int i=0; i<n-1; i++){
            if(nums.get(i)==majority){
                leftCount++;
            }
            int rightCount=totalCount-leftCount;

            if(leftCount*2>(i+1) && rightCount*2>(n-i-1)){
                return i;
            }
        }
        return -1;
    }
}