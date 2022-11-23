class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 99999;
      
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                
                if (sum == target) {
                    return target;
                }

                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }
                
                if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return ans;
    }
}
