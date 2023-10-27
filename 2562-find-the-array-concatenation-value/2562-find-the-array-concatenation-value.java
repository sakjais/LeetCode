class Solution {
    public long findTheArrayConcVal(int[] nums) {
   long ans = 0L;
        int low = 0 , high = nums.length-1;
        while(low <= high){
            String str1 = Long.toString(nums[low]) , str2 = Long.toString(nums[high]);
            str1 = str1 + str2;
            if(low == high) ans += nums[low]; 
            else ans +=(Long.parseLong(str1));
            low++; high--;
        }
        return ans;
    }
}
