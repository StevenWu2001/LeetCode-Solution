class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        curr_window = set()
        max_len, l = 0, 0

        for i, c in enumerate(s):
            while c in curr_window:
                curr_window.remove(s[l])
                l += 1

            curr_window.add(c)
            max_len = max(max_len, i - l + 1)
            
        return max_len
