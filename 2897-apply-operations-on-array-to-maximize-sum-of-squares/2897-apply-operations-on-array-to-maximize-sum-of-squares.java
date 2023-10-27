class Solution {
    public int maxSum(List<Integer> nums, int k) {
        long mod=1000000007;
        long result=0;
        int countBits[]=new int[32];    //counting bits at every position
        for(int i=0;i<nums.size();i++){//TC : 32*no.of elements
            for(int j=0;j<32;j++){
                if((nums.get(i) & (1<<j)) !=0)  //jth bit is set or not
                    countBits[j]++;
            }
        }
//we have count[] array that keeps tracks of no of sets bits at each position in the whole array
long cur=0;
        for(int i=0;i<k;i++){//K elements
         cur=0;
            for(int j=0;j<32;j++){  //32 bits
                if(countBits[j]>0)  //no of set bits at jth index is >0
                {
                    countBits[j]--;
                    cur +=(1<<j);    //jth time left shift
                }
            }
            result=(result + cur*cur%mod)%mod;
        }
        return (int)result;
    }
}