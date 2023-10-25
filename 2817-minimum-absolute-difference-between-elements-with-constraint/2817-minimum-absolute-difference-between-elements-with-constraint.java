class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = nums.size();
        for(int i = x; i < n; i++) {
            int val = nums.get(i);
            map.put(val, map.getOrDefault(val, 0)+1);
        }
        
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < (n-x); i++) {
            int val = nums.get(i);
            var flr = map.floorEntry(val);
            var cel = map.ceilingEntry(val);
            
            if(flr != null) {
                ans = Math.min(ans, val-flr.getKey());
            }
            if(cel != null) {
                ans = Math.min(ans, cel.getKey()-val);
            }
            
            val = nums.get(i+x);
            if(map.get(val) == 1) {
                map.remove(val);
            } else {
                map.put(val, map.get(val)-1);
            }
        }
        
        return ans;
    }
}