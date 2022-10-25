class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                if (check(s.charAt(l)) && check(s.charAt(r))) {
                    return false;
                } else {
                    if (!check(s.charAt(l))) {
                        l++;
                    }
                    
                    if (!check(s.charAt(r))) {
                        r--;
                    }
                }
            }
        }
        
        return true;
    }
    
    public boolean check(char c) {
        return Character.isLetterOrDigit(c);
    }
}
