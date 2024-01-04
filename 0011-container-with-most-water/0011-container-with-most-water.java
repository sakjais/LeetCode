class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int min = Math.min(height[left], height[right]);
            max = Math.max(max, min * (right - left));
            while (left < right && height[left] <= min) {
                left++;
            }

            while (left < right && height[right] <= min) {
                right--;
            }
        }
        return max;
    }
}