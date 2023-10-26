class Solution {
    public boolean canSplitArray(List<Integer> nums, int m) {
        int[][] dp = new int[nums.size()][nums.size()];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        
        int totalSum = 0;
        for(int i = 0; i < nums.size(); i++) totalSum += nums.get(i);
        
        return helper(nums, 0, nums.size() - 1, m, totalSum, dp);
    }
    
    private boolean helper(List<Integer> nums, int s, int e, int m, int totalSum, int[][] dp) {
        if(e - s <= 1) return true;
        if(dp[s][e] != -1) return dp[s][e] == 1 ? true : false;
        
        int prifixSum = 0;
        for(int i = s; i < e; i++) {
            prifixSum += nums.get(i);
            
            int suffixSum = totalSum - prifixSum;
            if((prifixSum == nums.get(s) || prifixSum >= m) && (suffixSum == nums.get(e) || suffixSum >= m)) {
                boolean left = helper(nums, s, i, m, prifixSum, dp);
                boolean right = helper(nums, i+1, e, m, suffixSum, dp);
                
                if(left && right) {
                    dp[s][e] = 1;
                    return true;
                } 
            }
        }  
        dp[s][e] = 0;
        return false;
    }
}