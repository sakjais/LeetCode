class Solution {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int[] ans = { -1, -1 };

        int start = 0, end = len - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                ans[0] = mid;
                ans[1] = mid;
                int left = mid - 1;
                while (left >= 0 && nums[left] == target) {
                    ans[0] = left;
                    left--;
                }

                int right = mid + 1;
                while (right < len && nums[right] == target) {
                    ans[1] = right;
                    right++;
                }

                return ans;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }
}
