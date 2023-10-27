class Solution {
Set<Integer> set = new HashSet<>();
    public int[] distinctDifferenceArray(int[] nums) {
       int[] ans = new int[nums.length];
       for(int i=0;i<nums.length;i++)
       {
           ans[i] = countFirst(0,i,nums)-countFirst(i+1,nums.length-1,nums);
       }

       return ans;
    }

    public int countFirst(int start, int end, int[] nums)
    {
        set.clear();
        for(int i=start;i<=end;i++)
        set.add(nums[i]);

        return set.size();
    }
}