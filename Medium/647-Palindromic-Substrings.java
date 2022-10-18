class Solution {
    public int countSubstrings(String s) {
        int ans = s.length();
        
        for (int i = 0; i < s.length(); i++) {
            int l = i - 1, r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                ans++;
                l--;
                r++;
            }
            
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                ans++;
                l--;
                r++;
            }
        }
        
        return ans;
    }
}
