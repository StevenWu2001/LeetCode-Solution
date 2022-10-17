class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        
        for (int i = 0; i < s.length(); i++) {
            int l = i - 1, r = i + 1;
            String cur = String.valueOf(s.charAt(i));
            while (l >= 0 && r < s.length()) {
                if (s.charAt(l) != s.charAt(r)) {
                    break;
                }
                cur = s.charAt(l) + cur + s.charAt(r);
                if (cur.length() >= ans.length()) {
                    ans = cur;
                }
                l--;
                r++;
            }
            
            l = i;
            r = i + 1;
            cur = "";
            while (l >= 0 && r < s.length()) {
                if (s.charAt(l) != s.charAt(r)) {
                    break;
                }
                cur = s.charAt(l) + cur + s.charAt(r);
                if (cur.length() >= ans.length()) {
                    ans = cur;
                }
                l--;
                r++;
            }
        }
        
        if (ans.length() == 0) {
            ans = String.valueOf(s.charAt(0));
        }
        return ans;
        
    }
}
