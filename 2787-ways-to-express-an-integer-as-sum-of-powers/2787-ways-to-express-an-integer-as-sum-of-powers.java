class Solution {
    int mod = (int)1e9+7;
    public int numberOfWays(int n, int x) {
        int[][] dp = new int[n+1][n+1];
        for(int[] row :dp)Arrays.fill(row,-1);
        return helper(1,x,n,dp);
    }
    private int helper(int ind ,int x, int target,int[][] dp){
         int val =(int)Math.pow(ind,x);
         if(target==val)return 1;
         if(val>target)return 0;
       if(dp[ind][target]!=-1)return dp[ind][target];
           int take =0;
            int not_take =0;
           
           take = helper(ind+1 ,x ,target - val,dp);
           not_take = helper(ind+1,x,target,dp);

       return dp[ind][target] =(take+not_take)%mod;
    }
}