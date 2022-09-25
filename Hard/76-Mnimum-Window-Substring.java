// Minimum sliding window solution

class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> target = new HashMap<>();
        Map<Character, Integer> curSub = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            target.merge(t.charAt(i), 1, Integer::sum);
            curSub.put(t.charAt(i), 0);
        }
        int l = 0, r = 0, match = 0;
        int minL = 0, minR = s.length();
        
        while (true) {
            if (target.containsKey(s.charAt(r))) {
                if (curSub.get(s.charAt(r)) < target.get(s.charAt(r))) {
                    match++;
                }
                curSub.merge(s.charAt(r), 1, Integer::sum);
            }
            
            while (match == t.length()) {
                if (r - l < minR - minL) {
                    minR = r;
                    minL = l;
                }
                
                if (target.containsKey(s.charAt(l))) {
                    if (curSub.get(s.charAt(l)) <= target.get(s.charAt(l))) {
                        match--;
                    }
                    curSub.merge(s.charAt(l), -1, Integer::sum);
                }
                l++;
            }
            
            r++;
            if (r == s.length()) {
                break;
            }
        }
        
        if (minR == s.length()) {
            return "";
        }

        return s.substring(minL, minR + 1);
    }
}
