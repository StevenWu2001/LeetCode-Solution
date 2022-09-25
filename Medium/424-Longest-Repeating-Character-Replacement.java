// Maximum sliding window

class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> window = new HashMap<>();
        int ans = 0, l = 0;
        
        for (int r = 0; r < s.length(); r++) {
            window.merge(s.charAt(r), 1, Integer::sum);
            while (r - l + 1 - maxFreq(window) > k) {
                window.merge(s.charAt(l++), -1, Integer::sum);
            }
            ans = Math.max(r - l + 1, ans);
        } 
        
        return ans;
    }
    
    public int maxFreq(Map<Character, Integer> map) {
        int max = 0;
        for (char c : map.keySet()) {
            max = Math.max(max, map.get(c));
        }
        return max;
    }
}
