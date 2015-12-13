class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result = []
        nums.sort()
        self.dfs(nums, 0, [], result)
        return result
        
    def dfs(self, nums, index, temp, result):
        result.append(temp)
        for i in range(index, len(nums)):
            self.dfs(nums, i + 1, temp + [nums[i]], result)