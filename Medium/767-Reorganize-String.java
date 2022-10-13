class Solution {
    public String reorganizeString(String s) {
        String ans = "";
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }
        
        char c = chooseChar(map, -1);
        int prev = c - 'a';
        ans += c;
        for (int i = 1; i < s.length(); i++) {
            c = chooseChar(map, prev);
            if (c == '!') {
                return "";
            }
            ans += c;
            prev = c - 'a';
        }
        
        return ans;
    }
    
    public char chooseChar(int[] map, int curr) {
        int max = 0, idx = -1;
        for (int i = 0; i < map.length; i++) {
            if (map[i] > max && curr != i) {
                max = map[i];
                idx = i;
            }
        }
        
        if (idx == -1) {
            return '!';
        } else {
            map[idx]--;
            return (char)(idx + 'a');
        }
    }
}
