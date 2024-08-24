class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        //Copy nums2 into the end of nums1
        for(int i=0;i<n;i++){
            nums1[m + i] = nums2[i];
        }
        
        //Sort the entire nums1 array
        Arrays.sort(nums1);
        
    }
}