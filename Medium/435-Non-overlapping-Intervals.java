class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return Integer.valueOf(a[1]).compareTo(Integer.valueOf(b[1]));
                }
                return Integer.valueOf(a[0]).compareTo(Integer.valueOf(b[0]));
            }
        });

        int ans = 0, end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                ans++;
                end = Math.min(end, intervals[i][1]);
            } else {
                end = intervals[i][1];
            }
        }

        return ans;
    }
}
