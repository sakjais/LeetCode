//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            int matrix[][] = new int[R][C];
            int c = 0;
            for(int i = 0; i < R; i++){
                String line[]=read.readLine().trim().split(" ");
                for(int j = 0; j < C; j++){
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix, R, C);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int smallOrEqual(int arr[], int target){
        
        int low = 0;
        int high = arr.length - 1;
        
        while(low<=high){
            int mid = low + (high - low)/2;
            
            if(arr[mid]<=target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }
    
    int median(int matrix[][], int R, int C) {
        // code here 
        
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<R;i++){
            min = Math.min(min,matrix[i][0]);
        }
        
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<R;i++){
            max = Math.max(max,matrix[i][C-1]);
        }
        
        int medianPos = ((R*C) + 1)/2;
        while(min<max){
            int mid = min + (max-min)/2;
            int count = 0;
            
            for(int i = 0;i<R;i++){
                count += smallOrEqual(matrix[i], mid);
            }
            
            if(count<medianPos){
                min = mid+1;
            }else{
                max = mid;
            }
        }
        return min;
    
        
    }
}