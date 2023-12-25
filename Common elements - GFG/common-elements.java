//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int n3 = sc.nextInt();
            
            int A[] = new int[n1];
            int B[] = new int[n2];
            int C[] = new int[n3];
            
            for (int i = 0;i < n1;i++)
            {
                A[i] = sc.nextInt();
            }
            for (int i = 0;i < n2;i++)
            {
                B[i] = sc.nextInt();
            }
            for (int i = 0;i < n3;i++)
            {
                C[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            ArrayList<Integer> res = sol.commonElements(A, B, C, n1, n2, n3);
            if (res.size() == 0)
            {
                System.out.print(-1);
            }
            else 
            {
                for (int i = 0;i < res.size();i++)
                {
                    System.out.print(res.get(i) + " ");
                }    
            }
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) {
        ArrayList<Integer> result = new ArrayList<>();

        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2 && k < n3) {
            // If the current elements in all three arrays are the same
            if (A[i] == B[j] && B[j] == C[k]) {
                result.add(A[i]);  // Common element found

                // Move all pointers until a different element is found to skip duplicates
                while (i < n1 - 1 && A[i] == A[i + 1]) i++;
                while (j < n2 - 1 && B[j] == B[j + 1]) j++;
                while (k < n3 - 1 && C[k] == C[k + 1]) k++;

                i++;
                j++;
                k++;
            } else if (A[i] < B[j]) {
                i++;
            } else if (B[j] < C[k]) {
                j++;
            } else {
                k++;
            }
        }

        // If no common elements found
        if (result.isEmpty()) {
            result.add(-1);
        }

        return result;
    }
}