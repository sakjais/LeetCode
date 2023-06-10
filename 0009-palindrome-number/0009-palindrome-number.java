class Solution {
    public boolean isPalindrome(int num) {
          int rev=0;
        int dup=num;
        while(num>0){
            int last=num%10;
            num=num/10;
            rev=(rev*10)+last;
    
        
    }
    if(rev!=dup)
    {
        return false;
    }
    return true;
    }
}