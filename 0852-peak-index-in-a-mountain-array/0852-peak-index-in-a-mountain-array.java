class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        
        int start = 0;
        int end = arr.length - 1;
        
        while(start < end){
            
            int mid = start + (end - start) / 2;
            if(arr[mid] > arr[mid+1]){
                //you are in decreasing part of array
                //his may be the answer, but look at left
                //this is why end is not equal to mid-1
                end = mid;
            }else{
                //you are in decreasing part of array
                start = mid + 1; //because we know that mid+1 element> mid element
            }
        }
        
        //in the end, start==end and pointing to the largest number because of 2 checks above
        return start;  //return end as both are equal
    }
}