class Solution {
    public int reverse(int x) {
        int a=0;
        if(x%10==0){
             a=x/10;
        }
        else{
             a=x;
        }
        int z=0;
        while(a!=0){
            if( z > Integer.MAX_VALUE / 10 || z < Integer.MIN_VALUE / 10 ){
            return 0;
            }
            z=z*10+a%10;
            a=a/10;
        }
        
        return z;
        
    }
}