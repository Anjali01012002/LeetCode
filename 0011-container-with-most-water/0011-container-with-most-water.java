class Solution {
    public int maxArea(int[] height) {
        int n = height.length;

        int i=0, j=n-1;

        int maxWater = 0;

        while(i<j){
            int width = j-i;

            int h= Math.min(height[i], height[j]);

            int area = width * h;

            maxWater= Math.max(maxWater, area);

            if(height[i] > height[j]){
                j--;
            }else{
                i++;
            }
        }
        return maxWater;
    }
}