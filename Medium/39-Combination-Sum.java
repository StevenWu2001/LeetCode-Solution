class Solution {
    List<Integer> current = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(0, target, candidates);
        return ans;
    }

    public void helper(int idx, int target, int[] candidates) {
        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        if (idx >= candidates.length || target < 0) {
            return;
        }

        current.add(candidates[idx]);
        helper(idx, target - candidates[idx], candidates);
        current.remove(current.size() - 1);
        helper(idx + 1, target, candidates);
    }
}
