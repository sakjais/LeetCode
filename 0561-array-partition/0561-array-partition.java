class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        for(int i=0; i<nums.length; i=i+2)
        {
            max = max + Math.min(nums[i],nums[i+1]);
        }
        return max;
    }
}