// Recursive Backtracking

class Solution {
    List<List<String>> ans = new ArrayList<>();
    List<String> cur = new ArrayList<>();
    
    public List<List<String>> partition(String s) {
        dfs(0, s);
        return ans;
    }
    
    public void dfs(int idx, String s) {
        if (idx >= s.length()) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        
        for (int j = idx; j < s.length(); j++) {
            if (palindrome(s, idx, j)) {
                cur.add(s.substring(idx, j + 1));
                dfs(j + 1, s);
                cur.remove(cur.size() - 1);
            }
        }
    }
    
    public boolean palindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
