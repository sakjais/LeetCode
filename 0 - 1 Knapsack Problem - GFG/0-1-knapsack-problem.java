//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{
    static int[] weight;
    static int[] values;
    static int knapSack(int W, int wt[], int val[], int n) 
    {
        int[][] res = new int[n+1][W+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(res[i],-1);
            
        }
        weight = wt;
        values = val;
        int result = getMaxValue(res,n,W);
        weight = null;
        values = null;
        return result;
       
    }
    
    public static int getMaxValue(int[][] res, int n,int w){
        if(w == 0 || n <= 0){
            return 0;
            
        }
        if(res[n][w] != -1){
            return res[n][w];
        }
        
        if(w >= weight[n-1]){
            int pick = values[n-1] + getMaxValue(res,n-1,w - weight[n-1]);
            int skip = getMaxValue(res,n-1,w);
            res[n][w] = Math.max(pick,skip);
            
        }else{
            res[n][w] = getMaxValue(res,n-1,w);
            
        }
        return res[n][w];
        
    }
}

