class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 1:
            return nums[0]

        a, b = nums[0], max(nums[0], nums[1])

        for i in range(2, len(nums)):
            tmp = b
            b = max(b, nums[i] + a)
            a = tmp
        
        return max(a, b)

        
