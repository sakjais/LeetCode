class Solution {
        public int countBeautifulPairs(int[] nums) {
        int pairs = 0;
        for (int i = 0; i < nums.length; ++i) {
            int d = nums[i] % 10;
            for (int j = 0; j < i; ++j) {
                int n = nums[j];
                while (n >= 10) {
                    n /= 10;
                }
                pairs += gcd(n, d) == 1 ? 1 : 0;
            }
        }
        return pairs;
    }
    private int gcd(int x, int y) {
        while (y != 0) {
            int tmp = x % y;
            x = y;
            y = tmp;
        }
        return x;
    }
}