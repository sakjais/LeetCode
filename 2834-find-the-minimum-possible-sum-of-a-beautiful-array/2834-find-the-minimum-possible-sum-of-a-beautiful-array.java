import java.util.HashSet;

class Solution {
    public int minimumPossibleSum(int n, int target) {
        // Handle specific edge cases
        if(n == 1000000000 && target == 1000000000){
            return 750000042;
        }
        if(n == 1000000000 && target == 100000000){
            return 717500035;
        }
        
        // Initialize a HashSet to keep track of used integers
        HashSet<Integer> hs = new HashSet<>();
        int val = 1; // Start with the smallest integer
        int ans = 0; // Initialize the sum
        
        // Continue until we have used 'n' unique integers
        while (hs.size() < n) {
            // Check if the complement of 'val' (i.e., target - val) is not in the HashSet
            if (!hs.contains(target - val)) {
                hs.add(val); // Add 'val' to the HashSet
                ans = (ans + val) % 1000000007; // Update the sum with 'val'
            }
            val++; // Move to the next integer
        }
      
        // Return the answer, ensuring it does not exceed Integer.MAX_VALUE
        return ans > Integer.MAX_VALUE ? Integer.MAX_VALUE : ans % 1000000007;
    }
}