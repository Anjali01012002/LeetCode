class Solution:
    def mergeArrays(self, nums1: List[List[int]], nums2: List[List[int]]) -> List[List[int]]:
        value_map={}

        for id, value in nums1:
            value_map[id]=value_map.get(id, 0)+value

        for id, value in nums2:
            value_map[id]=value_map.get(id, 0)+value

        result=[[id, value] for id, value in value_map.items()]

        result.sort(key=lambda x:x[0])

        return result