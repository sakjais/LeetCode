class Solution {
    public void nextPermutation(int[] nums) {
        int i=0;
        boolean flag=false;
        for(int j=nums.length-2;j>=0;j--)
        {
            if(nums[j]<nums[j+1])
            {
                i=j;
                flag=true;
                break;
            }
        }
        if(flag!=true)
        {
           for(int x=0;x<nums.length;x++)
        {
            for(int y=0;y<nums.length-1-x;y++)
            {
                if(nums[y]>nums[y+1])
                {
                    int temp=nums[y];
                    nums[y]=nums[y+1];
                    nums[y+1]=temp;
                }
            }
        }
        return;
        }
        for(int x=i+1;x<nums.length-1;x++)
        {
            for(int y=i+1;y<nums.length-1;y++)
            {
                if(nums[y]>nums[y+1])
                {
                    int temp=nums[y];
                    nums[y]=nums[y+1];
                    nums[y+1]=temp;
                }
            }
        }

        for(int x=i;x<nums.length-1;x++)
        {
            if(nums[x+1]>nums[i])
            {
                int temp2=nums[x+1];
                nums[x+1]=nums[i];
                nums[i]=temp2;
                break;
            }
        }

    }
}