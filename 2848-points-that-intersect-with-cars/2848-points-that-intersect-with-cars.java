class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        int sz = nums.size();
        
        int []pref = new int[200];
        
        for(var num : nums){
            pref[num.get(0)] += 1;
            pref[num.get(1)+1] -= 1;
        }
     
        for(int indx = 0; indx < pref.length; indx++){
           if(indx != 0) 
            pref[indx] += pref[indx-1];
        }
       
        int zeros = count(pref, 0);
      
        return 200 - zeros;
    }
    private int count(int pref[], int val){
        int cnt = 0;
        for(var num : pref){
            if(num == val)cnt++;
        }
        return cnt;
    }
}