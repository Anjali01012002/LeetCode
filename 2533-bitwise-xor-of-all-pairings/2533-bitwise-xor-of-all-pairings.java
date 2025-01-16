class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int result=0;
        if(m%2!=0){
            for(int nums:nums1){
                result^=nums;
            }
        }

        if(n%2!=0){
            for(int nums:nums2){
                result^=nums;
            }
        }

        return result;
    }
}