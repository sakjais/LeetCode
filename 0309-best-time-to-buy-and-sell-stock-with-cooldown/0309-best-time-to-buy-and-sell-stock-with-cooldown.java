class Solution {
    public int Solve(int [] prices ,  int[][] dp,int buy ,int ind)
    {
        if(ind>=prices.length)
            return 0;
        if(dp[ind][buy]!=-1)
            return dp[ind][buy];
        if(buy==1)
            return dp[ind][buy]=Math.max((-prices[ind]+Solve(prices,dp,0,ind+1)),0+Solve(prices,dp,1,ind+1));
        else
            return dp[ind][buy]=Math.max((prices[ind]+Solve(prices,dp,1,ind+2)),0+Solve(prices,dp,0,ind+1));
    }
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length][2];
        for(int []x:dp)
            Arrays.fill(x,-1);
        return Solve(prices,dp,1,0);
    }
}