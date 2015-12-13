class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        result = 0
        for i in range(0, 32):
            count = 0
            for temp in nums:
                if (temp >> i) & 1:
                    count += 1
            count = count % 3
            if i == 31 and count:
                result = result - (1 << 31)
            else:
                result = result | count * (1 << i)
        
        return result
            