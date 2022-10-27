// Solution 1
class Solution {
    public int numDecodings(String s) {
        int a = 0, b = 1;
        if (s.charAt(s.length() - 1) != '0') {
            a = 1;
        }
        
        for (int i = s.length() - 2; i >= 0; i--) {
            int temp = a;
            if (s.charAt(i) == '0') {
                temp = 0;
            }
            
            if (s.charAt(i) == '1' || (s.charAt(i) == '2' && "0123456".indexOf(s.charAt(i + 1)) != -1)) {
                temp += b;
            }
            b = a;
            a = temp;
        }
        
        return a;
    }
}

// Solution 2, more intuitive, but uses O(n) space.
class Solution {
    public int numDecodings(String s) {
        if (s.length() == 1) {
            return s.charAt(0) == '0' ? 0 : 1;
        }
        
        int[] dp = new int[s.length()];
        dp[s.length() - 1] = s.charAt(s.length() - 1) == '0' ? 0 : 1;
        dp[s.length() - 2] = dp[s.length() - 1];
        
        if (s.charAt(s.length() - 2) == '1' || (s.charAt(s.length() - 2) == '2' && s.charAt(s.length() - 1) < '7')) {
            dp[s.length() - 2] = 1 + dp[s.length() - 1];
        } else if (s.charAt(s.length() - 2) == '0') {
            dp[s.length() - 2] = 0;
        }
        
        for (int i = s.length() - 3; i >= 0; i--) {
            if (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else if (s.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i + 1];
            }
        }
        
        return dp[0];
    }
}
