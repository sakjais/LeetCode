class Solution {

    public int maximizeTheProfit(int n, List<List<Integer>> offers) {

        Collections.sort(offers, (a, b) -> a.get(0)-b.get(0));

        int [] dp = new int[offers.size() + 1];

        Arrays.fill(dp, -1);

        int ans = maxGold(n, offers, 0, dp);

        return ans;
        
    }


    int maxGold(int n, List<List<Integer>> offers, int idx, int [] dp){


        if(idx >= offers.size()) return 0;
        //skip

        if(dp[idx]!= -1) return dp[idx];

        int dontTake = maxGold(n, offers, idx + 1, dp);

        int nextIdx = lowerBound(offers, offers.get(idx).get(1)+1);

        int take =  offers.get(idx).get(2) + maxGold(n, offers, nextIdx, dp);

        return dp[idx] = Math.max(take, dontTake);
    }



    int lowerBound(List<List<Integer>> offers, int key){

        int l = 0;
        int ans = offers.size();
        int m = 0;
        int r =  offers.size()-1;

        while(l <= r){

            m = (l + r)/2;

            if(offers.get(m).get(0) >= key){
                ans = m;
                r =  m - 1;
            }else{
                l = m + 1;
            }
        }
        return ans;
    }
}