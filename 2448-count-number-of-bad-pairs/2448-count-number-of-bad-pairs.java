class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Integer, Integer> map=new HashMap<>();
        long n = nums.length;
        long totalPairs= n*(n-1)/2;
        long goodPairs=0;

        for(int i=0; i<n; i++){
            int key=nums[i]-i;
            goodPairs += map.getOrDefault(key, 0);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        return totalPairs - goodPairs;
    }
}