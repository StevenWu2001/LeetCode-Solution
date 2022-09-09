// Time: O(n!)

class Solution {
    List<Integer> cur = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> remain = new ArrayList<>();
        for (int n : nums) {
            remain.add(n);
        }
        dfs(remain);
        return ans;
    }
    
    public void dfs(List<Integer> remain) {
        if (remain.size() == 0) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        
        for (int i = 0; i < remain.size(); i++) {
            cur.add(remain.get(i));
            List<Integer> temp = new ArrayList<>(remain);
            temp.remove(i);
            dfs(temp);
            cur.remove(remain.get(i));
        }
    }
}
