// Reference: https://www.youtube.com/watch?v=Sx9NNgInc3A&ab_channel=NeetCode

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean dp[] = new boolean[s.length() + 1];
        dp[s.length()] = true;
        
        for (int i = s.length(); i >= 0; i--) {
            for (String word : wordDict) {
                if (i + word.length() <= s.length() && word.equals(s.substring(i, i + word.length()))) {
                    dp[i] = dp[i + word.length()];
                }
                if (dp[i]) {
                    break;
                }
            }
        }
            
        return dp[0];
    }
}

