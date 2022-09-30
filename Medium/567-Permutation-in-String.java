class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] target = new int[26], cur = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            target[s1.charAt(i) - 97]++;
            cur[s2.charAt(i) - 97]++;
        }
        
        for (int i = 1; i <= s2.length() - s1.length(); i++) {
            if (valid(target, cur)) {
                return true;
            }
            cur[s2.charAt(i - 1) - 97]--;
            cur[s2.charAt(i + s1.length() - 1) - 97]++;
        }
        
        return valid(target, cur);
    }
    
    public boolean valid(int[] target, int[] cur) {
        for (int i = 0; i < 26; i++) {
            if (target[i] != cur[i]) {
                return false;
            }
        }
        return true;
    }
}
