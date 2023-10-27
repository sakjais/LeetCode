class Solution {
    public int count;
    public boolean ispower(int num){
        int pow = 1;
        while(pow < num){
            pow = pow*5;
        }
        if(pow == num){return true;}
        return false;
    }
    public int backtrack(int ind, String s, Map<Integer,Integer> dp){
        // this.count++;
        if(ind >= s.length()){
            return 0;
        }
        if(dp.containsKey(ind)==true){
            return dp.get(ind);
        }
        if(s.charAt(ind) == '0'){
            return 999;
        } 
        
        int temp = 999;
        int run_count = 0;
        for(int i = ind; i < s.length();i++){
            run_count = run_count * 2;
            if(s.charAt(i) =='1'){
                run_count++;
            }
            if(this.ispower(run_count)==true){
                temp = Math.min(temp,1+this.backtrack(i+1,s,dp));
            }
            
        }
        dp.put(ind,temp);
        return temp;
    }
    public int minimumBeautifulSubstrings(String s) {
        Map<Integer,Integer> hm = new HashMap<>();
        
        int res = this.backtrack(0,s,hm);
        // System.out.println(count);
        int count = 0;this.count = count;
        if(res < 999){
            return res;
        }
        
        return -1;
    }
}