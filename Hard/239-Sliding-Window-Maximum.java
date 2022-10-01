// Monotonic Queue

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        dq.push(nums[0]);
        
        for (int i = 1; i < k; i++) {
            while (!dq.isEmpty() && dq.peekFirst() < nums[i]) {
                dq.pop();
            }
            dq.addFirst(nums[i]);
        }
        
        int idx = 0;
        ans[idx++] = dq.peekLast();
        for (int i = k; i < nums.length; i++) {
            if (nums[i - k] == dq.peekLast()) {
                dq.removeLast();
            }

            while (!dq.isEmpty() && dq.peekFirst() < nums[i]) {
                dq.removeFirst();
            }
            
            dq.addFirst(nums[i]);
            ans[idx++] = dq.peekLast();
        }
        
        return ans;
    }
}
