// Time: O(N^2)

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int prev = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == prev) {
                continue;
            }
            
            int prevL = Integer.MIN_VALUE;
            prev = nums[i];
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] + nums[i] == 0) {
                    if (nums[l] != prevL) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[l]);
                        temp.add(nums[r]);
                        temp.add(nums[i]);
                        ans.add(temp);
                        prevL = nums[l];
                    }        
                    l++;
                    r--;
                } else if (nums[l] + nums[r] + nums[i] < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return ans;
    }
}
