class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length==1){
            return  nums[nums.length-1];
        }
        Arrays.sort(nums);
        int n=nums.length;
        int count=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]==nums[i]){
                count=count+1;
            }
            else if(nums[i-1]!=nums[i]&&count>=n/2){
                return nums[i-1];
            }
            else if(nums[i-1]!=nums[i]&& count<=n/2){
                count=1;
            }
        }
        return nums[n-count];
    }
}