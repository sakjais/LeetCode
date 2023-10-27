class Solution {
    public int maximizeSum(int[] nums, int k) {
        Arrays.sort(nums);
        int l=nums.length;
        int sum=0,ans=0,t=1;
        for(int i=0;i<k;i++)
        {
          ans=ans+nums[l-1]+k-t;
          t++;
        }
       //last_element + k - t(t=elements removing increment order)
        return ans;
    }
}