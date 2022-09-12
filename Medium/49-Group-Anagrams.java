class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        
        for (String n : strs) {
            char[] temp = (new String(n)).toCharArray();
            Arrays.sort(temp);
            String sorted = String.valueOf(temp);
            
            if (map.containsKey(sorted)) {
                map.get(sorted).add(n);
            } else {
                map.put(sorted, new ArrayList<>());
                map.get(sorted).add(n);
            }
        }
        
        for (String key : map.keySet()) {
            ans.add(map.get(key));
        }
                
        return ans;
    }
}
