class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        if(prices[0] + prices[1] <= money && prices[0] + prices[1] >= 0){
            return money - (prices[0] + prices[1]);
        } 
        else return money;
    }
}