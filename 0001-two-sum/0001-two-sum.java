class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> a= new HashMap<>();
        int arr[] = new int[2];
        for(int i=0;i<nums.length;i++){
        a.put(target-nums[i], i);}
        for(int i=0;i<nums.length;i++){
         if(a.containsKey(nums[i]) && a.get(nums[i])!=i){
             arr[0] = a.get(nums[i]);
             arr[1] = i;
          return arr; }
  }
        
    return arr; 
    }
}