// Recursive Backtracking

class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> current = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0, nums);
        ans.add(new ArrayList<>());
        return ans;
    }
    
    public void backtrack(int idx, int[] nums) {
        if (idx >= nums.length) {
            return;
        }
        
        // Add the current element
        current.add(nums[idx]);
        ans.add(new ArrayList<>(current));
        backtrack(idx + 1, nums);
        
        // Skip the current element
        current.remove(new Integer(nums[idx]));
        backtrack(idx + 1, nums);
    }
}
