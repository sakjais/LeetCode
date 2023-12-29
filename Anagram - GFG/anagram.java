//{ Driver Code Starts
import java.util.*;
import java.util.stream.*; 
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args)throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    String str = br.readLine();
		    String s1 = str.split(" ")[0];
		    String s2 = str.split(" ")[1];
		    
		    Solution obj = new Solution();
		    
		    if(obj.isAnagram(s1,s2))
		    {
		        System.out.println("YES");
		    }
		    else
		    {
		         System.out.println("NO");
		    }
		    
		    
		    
		}
	}
}
// } Driver Code Ends


class Solution
{    
    //Function is to check whether two strings are anagram of each other or not.
    public static boolean isAnagram(String a,String b)
    {
      HashMap<Character, Integer> map = new HashMap<>();
 
        //entring key-value pair in the map from String a
        for(int i=0; i<a.length(); i++) {
            char currChar = a.charAt(i);
            map.put(currChar, map.getOrDefault(currChar, 0) + 1);
        }
 
        //loop on b string and checking if char present in map or not
        for(int i=0; i<b.length(); i++) {
            char currChar = b.charAt(i);
            if(map.get(currChar) != null) {
                if(map.get(currChar) == 1) {
                    map.remove(currChar);
                } else {
                    map.put(currChar, map.get(currChar)-1);
                }
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }
}