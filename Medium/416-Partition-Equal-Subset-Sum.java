class Solution {
    public boolean canPartition(int[] nums) {
        if (nums.length == 1) {
            return false;
        }
        
        int target = 0;
        for (int n : nums) {
            target += n;
        }
        
        if (target % 2 != 0) {
            return false;
        }
        
        target /= 2;
        
        HashSet<Integer> set = new HashSet<>();
        set.add(nums[0]);
        set.add(nums[1]);
        
        for (int i = 2; i < nums.length; i++) {
            HashSet<Integer> temp = new HashSet<>();
            for (int n : set) {
                temp.add(n);
                temp.add(n + nums[i]);
            }
            temp.add(nums[i]);
            set = temp;
        }
        
        return set.contains(target);
    }
}