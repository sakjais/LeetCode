class Solution {
    static public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int[][] dp=new int[nums.size()][target+1];
        for (int i = 0; i < nums.size(); i++) {
            Arrays.fill(dp[i],-1);
        }
        int a=fun(nums.size()-1,nums,target,dp);
        return (a==0 || a<=-2000000000)?-1:a;
    }
    static int fun(int i,List<Integer> nums, int target,int[][] dp ){
        if ((i<0 && target!=0) || target<0)
            return Integer.MIN_VALUE;

        if (target==0) {
            return 0;
        }
        if (dp[i][target]!=-1)
            return dp[i][target];
        int a=1+fun(i-1, nums, target-nums.get(i) ,dp);
        int b=fun(i-1, nums, target,dp);
        return dp[i][target]= Math.max(a,b);
    }
}