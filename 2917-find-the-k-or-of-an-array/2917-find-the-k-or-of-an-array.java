class Solution {
    public int findKOr(int[] nums, int k) { 
        int[] bitCount = new int[32];
        int result = 0;
        for (int num : nums) {
            for (int i = 0; i < 31; i++) {
                if ((num & (1 << i)) != 0) {
                    bitCount[i]++;
                    if (bitCount[i] == k) {
                        result += (1 << i);
                    }
                }
            }
        }
        return result;
    }
}