class Solution {
    public long maxSum(List<Integer> nums, int m, int k) {
        Map<Integer, Integer> exist = new HashMap<>();
        long count = 0;
        int i=0;
        long Sum = 0;
        int m_count = 0;
        long maxSum = 0;
        while(i<k-1){
            if(exist.containsKey(nums.get(i))){
                exist.put(nums.get(i),exist.get(nums.get(i))+1);
            }
            else{
                exist.put(nums.get(i),1);
                m_count++;
            }
            Sum+=nums.get(i);
            i++;
        }
        int start = 0;
        while(i < nums.size()){
            if(exist.containsKey(nums.get(i))){
                exist.put(nums.get(i),exist.get(nums.get(i))+1);
            }
            else{
                exist.put(nums.get(i),1);
                m_count++;
            }
            Sum+=nums.get(i);
            i++;
            if(m_count >= m){
                maxSum = Math.max(Sum,maxSum);
            }
            Sum-=nums.get(start);
            if(exist.get(nums.get(start)) == 1){
                exist.remove(nums.get(start));
                m_count--;
            }
            else{
                exist.put(nums.get(start),exist.get(nums.get(start))-1);
            }
            start++;
        }
        return maxSum;
    }
}