class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        l = 0
        r = len(height) - 1
        max_area = min(height[r], height[l]) * (r - l)

        while l < r:
            if height[l] == height[r]:
                l += 1
                r -= 1
            elif height[l] > height[r]:
                r -= 1
            else:
                l += 1

            max_area = max(max_area, min(height[r], height[l]) * (r - l))

        return max_area