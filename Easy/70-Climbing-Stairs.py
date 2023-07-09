class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 1:
            return 1

        a, b = 1, 2

        for i in range(n - 2, 0, -1):
            tmp = b
            b = tmp + a
            a = tmp

        return b
