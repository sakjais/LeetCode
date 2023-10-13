class Solution {
    public int maxSubarrays(int[] nums) {
        int all1=(1<<29)-1, minScore=all1, v=all1, cnt=0;
        for(int num: nums) minScore&=num;
        if(minScore!=0) return 1;
        for(int num: nums) {
            v&=num;
            if(v==0) {
                cnt++;
                v=all1;
            }
        }
        return cnt;
    }
}