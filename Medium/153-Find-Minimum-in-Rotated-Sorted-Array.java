class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (mid == 0) {
                break;
            }
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            } else if (nums[mid] > nums[r]) { // left sorted portion
                l = mid + 1;
            } else { // right sorted portion
                r = mid - 1;
            }
        }
        
        return Math.min(nums[0], nums[1]);
    }
}
