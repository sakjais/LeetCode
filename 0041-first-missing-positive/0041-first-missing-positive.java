class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) handle(nums, i, nums[i]);
        for (int i = 0; i < nums.length; i++) if (nums[i] != i+1) return i+1;
        return nums.length + 1;
    }

    private void handle(int[] nums, int i, int val) {
        if (i < 0 || val == i+1) return;
        if (val <= 0) nums[i] = 0;
        else if (val > nums.length) nums[i] = 0;
        else {
            int tmp = nums[val-1];
            nums[val-1] = val;
            if (tmp > 0 && tmp <= nums.length) handle(nums, val-1, tmp);
        }
    }
}