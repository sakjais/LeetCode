class Solution {
    public int minimumIndex(List<Integer> nums) 
    {
        int count = 1;
        int majorityElement = nums.get(0);
        int len = nums.size();
        for (int i=1;i<len;i++)
        {
            if (nums.get(i)==majorityElement)count++;
            else count--;
            
            if (count==0)
            {
                majorityElement=nums.get(i);
                count=1;
            }
        }
        //Finding Majority by Moore's Voting Algorithm
        
        int actual_count = 0;
        for(int i=0;i<len;i++){
            if(nums.get(i)==majorityElement)actual_count++;
        }
        // actual count of majority element
        
        int count_at_some_point =0;
        for(int i=0;i<len;i++)
        {
            if(majorityElement==nums.get(i))count_at_some_point++;
            
            if((count_at_some_point*2 > i-0+1) &&
               ((actual_count-count_at_some_point)*2>len-i-1))return i;
        }
        //dominant check
        return -1;    
    }
}