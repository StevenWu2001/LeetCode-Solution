class Solution {
    public int lengthOfLongestSubstring(String s) {
        String longest = "";
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (longest.indexOf(c) != -1) {
                longest = longest.substring(1);
            }
            longest += c;
            ans = Math.max(ans, longest.length());
        }
        
        return ans;
    }
}
