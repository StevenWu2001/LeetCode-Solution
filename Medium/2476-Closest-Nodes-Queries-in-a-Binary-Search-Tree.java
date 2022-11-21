/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> ans = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>();
        helper(set, root);
        for (int n : queries) {
            List<Integer> temp = new ArrayList<>();
            if (set.floor(n) == null) {
                temp.add(-1);
            } else {
                temp.add(set.floor(n));
            }
            
            if (set.ceiling(n) == null) {
                temp.add(-1);
            } else {
                temp.add(set.ceiling(n));
            }
            
            ans.add(temp);
        }
        
        return ans;
    }
    
    public void helper(TreeSet<Integer> set, TreeNode root) {
        if (root == null) {
            return;
        }
        set.add(root.val);
        helper(set, root.left);
        helper(set, root.right);
    }
}
