class Solution {
    public int maxDivScore(int[] nums, int[] divisors) {
        int max = 0;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < divisors.length; i++){
            int count = 0;
            for (int j = 0; j < nums.length; j++){
                if (nums[j] % divisors[i] == 0){
                    count++;
                }
            }
            if (count > max || (count == max && divisors[i] < ans)){
                max = count;
                ans = divisors[i];
            }
        }
        return ans;
    }
}