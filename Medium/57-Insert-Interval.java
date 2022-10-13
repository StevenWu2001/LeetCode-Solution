class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int minInt = newInterval[0], maxInt = newInterval[1];
        boolean added = false;
        for (int i = 0; i < intervals.length; i++) {
            int s = intervals[i][0], e = intervals[i][1];
            if (s > newInterval[1] || e < newInterval[0]) {
                if (!added && s > newInterval[0]) {
                    ans.add(new int[] {minInt, maxInt});
                    added = true;
                }
                ans.add(intervals[i]);
            } else {
                minInt = Math.min(minInt, Math.min(newInterval[0], s));
                maxInt = Math.max(maxInt, Math.max(newInterval[1], e));
                if (i == intervals.length - 1) {
                    ans.add(new int[] {minInt, maxInt});
                    added = true;
                }
            }
        }
        
        if (!added) {
            ans.add(newInterval);
        }

        return ans.toArray(new int[ans.size()][2]);
    }
}
