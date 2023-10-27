class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] ans = new int[nums.length];

        int first = 0;
        int left = 0;
        int right;

        for (int i : nums)
            first += i;
        
        ans[0] = first = right = Math.abs(first - nums[0]);
        //at this point, left=0, right=15,first element = 15;
        for (int j = 1; j < nums.length; j++)
        {
            left += nums[j - 1];
            right -= nums[j];
            ans[j] = Math.abs(left - right);
        }
        return ans;
    }
}