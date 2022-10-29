class Solution {
    public int trap(int[] height) {
        int idx = 0, total = 0;
        Stack<int[]> stack = new Stack<>(); // Stores [elevation, idx], the elevations are in monotonic decreasing order
        
        while (idx < height.length) {
            
            // Skip the 0 heights
            
            if (height[idx] == 0) {
                idx++;
                continue;
            }
            
            if (stack.isEmpty()) {  // If nothing is on the stack, simply push it
                stack.push(new int[] {height[idx], idx});
            } else {
                // If we encounter an elevation no greater than the stack top,
                // Calculate the water that it can store with the stack top,
                // And push it to the stack
                
                if (height[idx] <= stack.peek()[0]) {
                    total += height[idx] * (idx - stack.peek()[1] - 1);
                    stack.push(new int[] {height[idx], idx});
                } else {
                    // If we encounter an elevation larger than the stack top,
                    // Pop the stack until a larger elevation is at the stack top
                    // We also need to calculate how much water can be stored as we pop the stack
                    
                    int prev = 0; // Stores the height of already calculated water, so no overlap occurs
                    
                    while (!stack.isEmpty()) {
                        total += (Math.min(stack.peek()[0], height[idx]) - prev) * (idx - stack.peek()[1] - 1);
                        
                        if (height[idx] < stack.peek()[0]) {
                            break;
                        } 
                        
                        prev = stack.pop()[0];
                    }
                    
                    // After all smaller elevations are popped, push the current to the stack
                    
                    stack.push(new int[] {height[idx], idx});
                }
            }
            
            // Move on to the next elevation
            
            idx++;
        }
        
        return total;
    }
}