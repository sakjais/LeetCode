class Solution {
    public int findNonMinOrMax(int[] nums) {
        if(nums.length<3) return -1;

        return Math.max(Math.min(Math.max(nums[0], nums[1]),nums[2]), Math.min(nums[0],nums[1]));
    }
}