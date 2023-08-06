class Solution {
    public int accountBalanceAfterPurchase(int p) {
    int n=p%10;
        int x=10-n;
    if(n>=5){
            return Math.abs(100-(p+x));
        }else{
            return Math.abs(100-(p-n));
        }
    
    }
}