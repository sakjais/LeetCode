class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] minJumps = new int[n];
        minJumps[0] = 0;
        Arrays.fill(minJumps,1,n,Integer.MAX_VALUE);
        int filledTill = 1;
        for(int i=0;i<n;i++)  {
            int j = filledTill;
            int reach = nums[i] + i;
            while(j<n && j<=reach) {
                if((minJumps[i] + 1) < minJumps[j]) {
                    minJumps[j] = (minJumps[i] + 1);
                }
                j++;
                filledTill = j;
            }
        }
        return minJumps[n-1];
    }
}