// Time: O(nlog(k))

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
                                                 
        for (int i = 0; i < nums.length; i++) {
            map.merge(nums[i], 1, Integer::sum);
        }
                                                  
        int freq[][] = new int[map.size()][2];
        int idx = 0;
        for (int n : map.keySet()) {
            freq[idx][0] = n;
            freq[idx++][1] = map.get(n);
        }
        
        Arrays.sort(freq, new Comparator<int[]>() {
           @Override
           public int compare(int[] a, int[] b) {
               return -1 * Integer.valueOf(a[1]).compareTo(Integer.valueOf(b[1]));
           }
        });
        
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = freq[i][0];
        }
        
        return ans;
    }
}
